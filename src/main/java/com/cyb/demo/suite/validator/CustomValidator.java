package com.cyb.demo.suite.validator;

import com.cyb.demo.suite.annotation.CustomValidation;
import org.springframework.util.StringUtils;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidator implements ConstraintValidator<CustomValidation,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String[] arr=StringUtils.delimitedListToStringArray(s,"-");
        if(arr.length!=2) return false;
        boolean f1=arr[0].equals("ZH");
        boolean f2=arr[1].length()==6 && org.apache.commons.lang3.StringUtils.isNumeric(arr[1]);
        return f1 && f2;
    }
}
