package eu.lundegaard.testform.service;

import eu.lundegaard.testform.domain.RequestKind;
import eu.lundegaard.testform.model.RequestKindResponseDto;

import java.util.List;

/**
 * This interface is a service layer that ensures extracting all given kinds of requests from the database
 *
 * @see RequestKind
 */
public interface RequestKindService {

    /**
     * This method returns a list of response DTOs of all given Kinds of requests persisted in the database
     *
     * @return a list of response DTOs of all given Kinds of requests persisted in the database
     * @see RequestKind
     * @see RequestKindResponseDto
     */
    List<RequestKindResponseDto> getAllRequestKinds();
}
