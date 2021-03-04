package eu.lundegaard.testform.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class AlphanumericValidationTest {

    private final AlphanumericValidation validator = new AlphanumericValidation();

    private static Object[] isValid_isTrue() {
        return new Object[]{
                "abcdefghijklmnopqrstuvwxyz",
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                "0123456789"
        };
    }

    @ParameterizedTest
    @MethodSource
    void isValid_isTrue(String input) {
        boolean result = validator.isValid(input, null);

        assertThat(result).isTrue();
    }

    private static Object[] isValid_isFalse() {
        return new Object[]{
                "+-*/",
                "ěščřžýáíéúů",
                " "
        };
    }

    @ParameterizedTest
    @MethodSource
    void isValid_isFalse(String input) {
        boolean result = validator.isValid(input, null);

        assertThat(result).isFalse();
    }
}