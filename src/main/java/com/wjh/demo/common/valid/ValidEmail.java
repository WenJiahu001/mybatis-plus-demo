package com.wjh.demo.common.valid;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
public @interface ValidEmail {
 
	String message() default "邮箱格式不正确" ;
 
	Class<?>[] groups() default { };
 
	Class<? extends Payload>[] payload() default { };
}
