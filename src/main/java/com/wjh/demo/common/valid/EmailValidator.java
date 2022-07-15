package com.wjh.demo.common.valid;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2022/5/12 18:11
 *
 * @author wenjiahu
 */
public class EmailValidator implements ConstraintValidator<ValidEmail, Object> {


    @Override
    public void initialize(ValidEmail validEmail) {
        System.out.println("ValidEmail init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String name = (String) value;
        if (StringUtils.isEmpty(name))
            return true;
        String regex = "^[\\w]+@[\\w]+\\.[a-zA-Z]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(name);
        return m.find();
    }

}
