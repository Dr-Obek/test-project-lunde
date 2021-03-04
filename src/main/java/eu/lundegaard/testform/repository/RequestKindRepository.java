package eu.lundegaard.testform.repository;

import eu.lundegaard.testform.domain.RequestKind;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestKindRepository extends CrudRepository<RequestKind, Long> {

    Optional<RequestKind> findByKindOfRequest(String kindOfRequest);
}
