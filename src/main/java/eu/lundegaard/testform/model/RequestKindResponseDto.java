package eu.lundegaard.testform.model;

import eu.lundegaard.testform.domain.RequestKind;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class represents a response data transfer object of RequestKind
 *
 * @see RequestKind
 */
@Data
@AllArgsConstructor
public class RequestKindResponseDto {

    private String kindOfRequest;
}
