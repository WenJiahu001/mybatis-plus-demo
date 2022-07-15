package com.wjh.demo.security;

import com.wjh.demo.business.test.entity.User;
import com.wjh.demo.business.test.service.UserService;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class UserModelDetailsService implements UserDetailsService {

   private final Logger log = LoggerFactory.getLogger(UserModelDetailsService.class);

   private final UserService userService;

   public UserModelDetailsService(UserService userService) {
      this.userService = userService;
   }

   @Override
   @Transactional
   public UserDetails loadUserByUsername(final String login) {
      log.debug("Authenticating user '{}'", login);

      //邮箱登录暂时不要
//      if (new EmailValidator().isValid(login, null)) {
//         return userService.findOneWithAuthoritiesByEmailIgnoreCase(login)
//            .map(user -> createSpringSecurityUser(login, user))
//            .orElseThrow(() -> new UsernameNotFoundException("User with email " + login + " was not found in the database"));
//      }

      String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
      return userService.findOneWithAuthoritiesByUsername(lowercaseLogin)
         .map(user -> createSpringSecurityUser(lowercaseLogin, user))
         .orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));

   }

   private org.springframework.security.core.userdetails.User createSpringSecurityUser(String lowercaseLogin, User user) {
//      if (!user.isActivated()) {
//         throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
//      }
      //todo 授权信息写死
      ArrayList<String> authorities = new ArrayList<>();
      List<GrantedAuthority> grantedAuthorities = authorities.stream()
         .map(authority -> new SimpleGrantedAuthority(authority))
         .collect(Collectors.toList());
      return new org.springframework.security.core.userdetails.User(user.getId().toString(),
         user.getPassword(),
         grantedAuthorities);
   }
}
