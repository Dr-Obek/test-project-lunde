package eu.lundegaard.testform.repository;

import eu.lundegaard.testform.domain.ContactForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactFormRepository extends CrudRepository<ContactForm, Long> {
}
