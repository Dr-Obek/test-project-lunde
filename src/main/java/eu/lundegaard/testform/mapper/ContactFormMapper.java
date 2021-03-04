package eu.lundegaard.testform.mapper;

import eu.lundegaard.testform.domain.ContactForm;
import eu.lundegaard.testform.model.ContactFormRequestDto;
import eu.lundegaard.testform.model.ContactFormResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ContactFormMapper {

    @Mapping(target = "kindOfRequest", ignore = true)
    ContactFormResponseDto mapToDto(ContactForm contactForm);

    @Mapping(target = "requestKind", ignore = true)
    ContactForm mapToDomain(ContactFormRequestDto contactFormRequestDto);
}
