package eu.lundegaard.testform.service.impl;

import eu.lundegaard.testform.domain.RequestKind;
import eu.lundegaard.testform.mapper.RequestKindMapper;
import eu.lundegaard.testform.model.RequestKindResponseDto;
import eu.lundegaard.testform.repository.RequestKindRepository;
import eu.lundegaard.testform.testData.RequestKindTestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RequestKindServiceImplTest {

    @Mock
    private RequestKindRepository requestKindRepository;

    @Spy
    private final RequestKindMapper requestKindMapper = Mappers.getMapper(RequestKindMapper.class);

    @InjectMocks
    private RequestKindServiceImpl requestKindService;

    @Test
    void getAllRequestKinds() {
        Iterable<RequestKind> requestKinds = RequestKindTestData.getRequestKinds();

        when(requestKindRepository.findAll()).thenReturn(requestKinds);

        final List<RequestKindResponseDto> result = requestKindService.getAllRequestKinds();

        assertThat(result).containsAll(StreamSupport.stream(requestKinds.spliterator(), false)
                .map(requestKindMapper::mapToDto)
                .collect(Collectors.toList()));
    }
}