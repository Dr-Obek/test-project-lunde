package eu.lundegaard.testform.service.impl;

import eu.lundegaard.testform.domain.ContactForm;
import eu.lundegaard.testform.domain.RequestKind;
import eu.lundegaard.testform.exception.RequestKindNotFoundException;
import eu.lundegaard.testform.mapper.ContactFormMapper;
import eu.lundegaard.testform.model.ContactFormRequestDto;
import eu.lundegaard.testform.model.ContactFormResponseDto;
import eu.lundegaard.testform.repository.ContactFormRepository;
import eu.lundegaard.testform.repository.RequestKindRepository;
import eu.lundegaard.testform.service.ContactFormService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class implements a service layer for saving the contact form into the database
 *
 * @see ContactFormService
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ContactFormServiceImpl implements ContactFormService {

    private final ContactFormRepository contactFormRepository;
    private final RequestKindRepository requestKindRepository;
    private final ContactFormMapper contactFormMapper;

    @Override
    @Transactional
    public ContactFormResponseDto submitForm(ContactFormRequestDto contactFormRequestDto) {
        log.info("Called submitForm.");
        log.debug("Called submitForm. Input [{}]", contactFormRequestDto);
        ContactForm contactFormToSubmit = contactFormMapper.mapToDomain(contactFormRequestDto);
        String kindOfRequestStringToSubmit = contactFormRequestDto.getKindOfRequest();
        RequestKind requestKind = requestKindRepository.findByKindOfRequest(kindOfRequestStringToSubmit)
                .orElseThrow(() -> new RequestKindNotFoundException("Kind of request from form to submit not found in the database."));
        log.debug("Kind of request: [{}]", kindOfRequestStringToSubmit);
        contactFormToSubmit.setRequestKind(requestKind);

        ContactForm savedContactForm = contactFormRepository.save(contactFormToSubmit);
        log.debug("Form [{}] has been submitted and saved to the database.\nOutput: [{}]", contactFormToSubmit, savedContactForm);
        ContactFormResponseDto submittedContactForm = contactFormMapper.mapToDto(savedContactForm);
        submittedContactForm.setKindOfRequest(savedContactForm.getRequestKind().getKindOfRequest());
        return submittedContactForm;
    }
}
