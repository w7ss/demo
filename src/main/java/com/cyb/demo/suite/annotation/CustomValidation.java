package com.cyb.demo.suite.annotation;

import com.cyb.demo.suite.validator.CustomValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义参数校验注解
 */
@Target({/*ElementType.METHOD,*/ ElementType.FIELD/*, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE*/})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {CustomValidator.class}
)
public @interface CustomValidation {
    String message() default "{ com.cyb.demo.suite.annotation.CustomValidation.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
