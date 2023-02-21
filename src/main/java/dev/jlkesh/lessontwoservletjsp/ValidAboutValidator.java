package dev.jlkesh.lessontwoservletjsp;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidAboutValidator implements ConstraintValidator<ValidAbout, String> {
    private int wordCount;

    @Override
    public void initialize(ValidAbout constraintAnnotation) {
        this.wordCount = constraintAnnotation.wordCount();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null)
            return false;
        if (value.isBlank())
            return false;
        String[] words = value.split("\\W");
        return words.length >= wordCount;
    }
}
