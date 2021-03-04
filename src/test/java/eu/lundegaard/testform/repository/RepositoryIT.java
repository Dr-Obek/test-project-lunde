package eu.lundegaard.testform.repository;

import eu.lundegaard.testform.domain.ContactForm;
import eu.lundegaard.testform.domain.RequestKind;
import eu.lundegaard.testform.testData.ContactFormTestData;
import eu.lundegaard.testform.testData.RequestKindTestData;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RepositoryIT {

    @Autowired
    private ContactFormRepository contactFormRepository;

    @Autowired
    private RequestKindRepository requestKindRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void saveContactForm() {
        final ContactForm contactForm = ContactFormTestData.getTestContactForm();

        entityManager.persistAndFlush(contactForm);
        entityManager.detach(contactForm);

        final Optional<ContactForm> result = contactFormRepository.findById(contactForm.getId());

        assertThat(result).isPresent();
        SoftAssertions.assertSoftly(softly -> {
            assertThat(result.get().getId()).isEqualTo(contactForm.getId());
            assertThat(result.get().getRequestKind()).isEqualTo(contactForm.getRequestKind());
            assertThat(result.get().getPolicyNo()).isEqualTo(contactForm.getPolicyNo());
            assertThat(result.get().getFirstName()).isEqualTo(contactForm.getFirstName());
            assertThat(result.get().getLastName()).isEqualTo(contactForm.getLastName());
            assertThat(result.get().getRequestText()).isEqualTo(contactForm.getRequestText());
        });
    }

    @Test
    void findByKindOfRequest() {
        final RequestKind requestKind = RequestKindTestData.getTestRequestKind();

        entityManager.persist(requestKind);
        entityManager.detach(requestKind);

        final Optional<RequestKind> result = requestKindRepository.findByKindOfRequest(requestKind.getKindOfRequest());

        assertThat(result).isPresent();
        SoftAssertions.assertSoftly(softly -> {
            assertThat(result.get().getId()).isEqualTo(requestKind.getId());
            assertThat(result.get().getKindOfRequest()).isEqualTo(requestKind.getKindOfRequest());
        });
    }
}