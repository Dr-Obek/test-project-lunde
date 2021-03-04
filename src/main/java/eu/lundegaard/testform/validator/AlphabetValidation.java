package eu.lundegaard.testform.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AlphabetValidation implements ConstraintValidator<Alphabet, String> {

    @Override
    public boolean isValid(String textField, ConstraintValidatorContext context) {
        return textField != null && textField.matches("^[a-zA-Z]*$");
    }
}
