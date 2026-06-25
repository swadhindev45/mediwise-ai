package mediwise_backend.repository;

import mediwise_backend.entity.SymptomMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SymptomRepository extends JpaRepository<SymptomMapping,Long> {
    Optional<SymptomMapping> findBySymptomIgnoreCase(String symptom);
}
