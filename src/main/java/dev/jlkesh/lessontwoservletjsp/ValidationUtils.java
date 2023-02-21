package dev.jlkesh.lessontwoservletjsp;

import dev.jlkesh.lessontwoservletjsp.dto.ErrorDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;
import java.util.stream.Collectors;

public class ValidationUtils {
    public static <T> Set<ErrorDTO> validate(T t, Class<T> clazz) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(t, clazz);
        return violations.stream()
                .map(violation -> new ErrorDTO(
                        violation.getPropertyPath().toString(),
                        violation.getInvalidValue(),
                        violation.getMessage()))
                .collect(Collectors.toSet());
    }
}
