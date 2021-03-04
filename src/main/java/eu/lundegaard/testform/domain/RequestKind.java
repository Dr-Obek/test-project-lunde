package eu.lundegaard.testform.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "request_kinds")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestKind {

    @Id
    private Long id;

    @NotNull
    @Column(unique = true, insertable = false, updatable = false, name = "kind_of_request")
    @ReadOnlyProperty
    private String kindOfRequest;
}
