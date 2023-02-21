package dev.jlkesh.lessontwoservletjsp;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Min;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ValidAboutValidator.class})
public @interface ValidAbout {
    String message() default "Valid About Field Must have {wordCount} or more words";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int wordCount() default 5;
}
