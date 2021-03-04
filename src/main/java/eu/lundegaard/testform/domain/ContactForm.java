package eu.lundegaard.testform.domain;

import eu.lundegaard.testform.validator.Alphabet;
import eu.lundegaard.testform.validator.Alphanumeric;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "contact_forms")
@EntityListeners(AuditingEntityListener.class)
@Data
public class ContactForm {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kind_of_request")
    @NotNull
    private RequestKind requestKind;

    @Alphanumeric
    @Column(unique = true, name = "policy_number")
    @NotNull
    private String policyNo;

    @Alphabet
    @Column(name = "name")
    @NotNull
    private String firstName;

    @Alphabet
    @Column(name = "surname")
    @NotNull
    private String lastName;

    @Column(name = "request_text")
    @NotNull
    private String requestText;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
