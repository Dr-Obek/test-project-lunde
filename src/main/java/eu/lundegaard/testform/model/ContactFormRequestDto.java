package eu.lundegaard.testform.model;

import eu.lundegaard.testform.domain.ContactForm;
import eu.lundegaard.testform.validator.Alphabet;
import eu.lundegaard.testform.validator.Alphanumeric;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This class represents a request data transfer object of ContactForm
 *
 * @see ContactForm
 */
@Data
public class ContactFormRequestDto {

    private String kindOfRequest;

    @Alphanumeric(message = "This field has to contain only alphanumeric characters")
    @NotNull(message = "This field cannot be empty.")
    private String policyNo;

    @Alphabet(message = "This field has to contain only alphabet characters.")
    @NotNull(message = "This field cannot be empty.")
    private String firstName;

    @Alphabet(message = "This field has to contain only alphabet characters.")
    @NotNull(message = "This field cannot be empty.")
    private String lastName;

    @NotNull(message = "This field cannot be empty.")
    @Size(max = 5000, message = "Size of this field cannot exceed 5000 characters.")
    private String requestText;
}
