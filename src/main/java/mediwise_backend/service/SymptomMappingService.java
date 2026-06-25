package mediwise_backend.service;

import lombok.RequiredArgsConstructor;
import mediwise_backend.entity.SymptomMapping;
import mediwise_backend.repository.SymptomRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SymptomMappingService {

    private final SymptomRepository symptomRepository;

    public String recommendSpecialist(String symptom) {

        SymptomMapping mapping =
                symptomRepository.findBySymptom(symptom)
                        .orElseThrow();

        return mapping.getSpecialist();
    }
}