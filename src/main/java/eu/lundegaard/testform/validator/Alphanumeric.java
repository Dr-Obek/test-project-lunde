package eu.lundegaard.testform.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AlphanumericValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Alphanumeric {

    String message() default "Invalid entry. Only alphanumeric characters allowed.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
