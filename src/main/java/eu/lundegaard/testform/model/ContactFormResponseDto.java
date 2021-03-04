package eu.lundegaard.testform.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import eu.lundegaard.testform.domain.ContactForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * This class represents a response data transfer object of ContactForm
 *
 * @see ContactForm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactFormResponseDto {

    private String kindOfRequest;
    private String policyNo;
    private String firstName;
    private String lastName;
    private String requestText;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createdAt;
}
