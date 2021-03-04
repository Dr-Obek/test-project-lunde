package eu.lundegaard.testform.service.impl;

import eu.lundegaard.testform.domain.ContactForm;
import eu.lundegaard.testform.domain.RequestKind;
import eu.lundegaard.testform.exception.RequestKindNotFoundException;
import eu.lundegaard.testform.mapper.ContactFormMapper;
import eu.lundegaard.testform.model.ContactFormRequestDto;
import eu.lundegaard.testform.model.ContactFormResponseDto;
import eu.lundegaard.testform.repository.ContactFormRepository;
import eu.lundegaard.testform.repository.RequestKindRepository;
import eu.lundegaard.testform.testData.ContactFormTestData;
import eu.lundegaard.testform.testData.RequestKindTestData;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ContactFormServiceImplTest {

    @Mock
    private ContactFormRepository contactFormRepository;

    @Mock
    private RequestKindRepository requestKindRepository;

    @Spy
    private final ContactFormMapper contactFormMapper = Mappers.getMapper(ContactFormMapper.class);

    @InjectMocks
    private ContactFormServiceImpl contactFormService;

    @Test
    void submitForm() {
        ContactFormRequestDto contactFormRequestDto = ContactFormTestData.getTestContactFormRequestDto();
        RequestKind requestKindTestData = RequestKindTestData.getTestRequestKind();

        ContactForm contactFormToSubmit = contactFormMapper.mapToDomain(contactFormRequestDto);
        String kindOfRequestStringToSubmit = contactFormRequestDto.getKindOfRequest();
        when(requestKindRepository.findByKindOfRequest(kindOfRequestStringToSubmit))
                .thenReturn(Optional.of(requestKindTestData));
        contactFormToSubmit.setRequestKind(requestKindTestData);

        when(contactFormRepository.save(contactFormToSubmit))
                .thenReturn(contactFormToSubmit);

        final ContactFormResponseDto result = contactFormService.submitForm(contactFormRequestDto);

        assertThat(result).isNotNull();
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(result.getKindOfRequest()).isEqualTo(contactFormRequestDto.getKindOfRequest());
            softly.assertThat(result.getPolicyNo()).isEqualTo(contactFormRequestDto.getPolicyNo());
            softly.assertThat(result.getFirstName()).isEqualTo(contactFormRequestDto.getFirstName());
            softly.assertThat(result.getLastName()).isEqualTo(contactFormRequestDto.getLastName());
            softly.assertThat(result.getRequestText()).isEqualTo(contactFormRequestDto.getRequestText());
        });
    }

    @Test
    void submitForm_kindOfRequestNotFound() {
        ContactFormRequestDto contactFormRequestDto = ContactFormTestData.getTestContactFormRequestDto();
        String kindOfRequestStringToSubmit = contactFormRequestDto.getKindOfRequest();

        when(requestKindRepository.findByKindOfRequest(kindOfRequestStringToSubmit))
                .thenReturn(Optional.empty());
        requestKindRepository.findByKindOfRequest(kindOfRequestStringToSubmit);

        RequestKindNotFoundException requestKindNotFoundException = assertThrows(RequestKindNotFoundException.class, () -> contactFormService.submitForm(contactFormRequestDto));
        assertThat(requestKindNotFoundException.getMessage()).isEqualTo("Kind of request from form to submit not found in the database.");
    }
}