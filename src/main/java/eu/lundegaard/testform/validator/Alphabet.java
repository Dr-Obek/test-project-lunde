package eu.lundegaard.testform.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AlphabetValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Alphabet {

    String message() default "Invalid entry. Only alphabet characters allowed.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
