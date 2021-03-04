package eu.lundegaard.testform.service;

import eu.lundegaard.testform.domain.ContactForm;
import eu.lundegaard.testform.exception.RequestKindNotFoundException;
import eu.lundegaard.testform.model.ContactFormRequestDto;
import eu.lundegaard.testform.model.ContactFormResponseDto;

/**
 * This interface is a service layer that ensures saving the contact form into the database
 *
 * @see ContactForm
 */
public interface ContactFormService {

    /**
     * This method ensures saving of a submitted Contact Form into the database
     *
     * @param contactFormRequestDto a request DTO of a submitted Contact Form
     * @return a response DTO of persisted Contact Form
     * @throws RequestKindNotFoundException when RequestKind property of submitted Contact Form cannot be found in the database
     * @see ContactForm
     * @see ContactFormRequestDto
     * @see ContactFormResponseDto
     */
    ContactFormResponseDto submitForm(ContactFormRequestDto contactFormRequestDto);
}
