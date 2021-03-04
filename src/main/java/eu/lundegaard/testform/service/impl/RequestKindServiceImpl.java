package eu.lundegaard.testform.service.impl;

import eu.lundegaard.testform.mapper.RequestKindMapper;
import eu.lundegaard.testform.model.RequestKindResponseDto;
import eu.lundegaard.testform.repository.RequestKindRepository;
import eu.lundegaard.testform.service.RequestKindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * This class implements a service layer that ensures extracting all given kinds of requests from the database
 *
 * @see RequestKindService
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RequestKindServiceImpl implements RequestKindService {

    private final RequestKindRepository requestKindRepository;
    private final RequestKindMapper requestKindMapper;

    @Override
    @Transactional(readOnly = true)
    public List<RequestKindResponseDto> getAllRequestKinds() {
        log.info("Called getAllRequestKinds.");

        List<RequestKindResponseDto> response = StreamSupport.stream(requestKindRepository.findAll().spliterator(), false)
                .map(requestKindMapper::mapToDto)
                .collect(Collectors.toList());
        log.debug("All kinds of requests from the database have been returned.\nOutput: [{}]", response);
        return response;
    }
}
