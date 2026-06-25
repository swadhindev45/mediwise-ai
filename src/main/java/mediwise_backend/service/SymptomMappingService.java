package mediwise_backend.service;

import lombok.RequiredArgsConstructor;
import mediwise_backend.entity.Doctor;
import mediwise_backend.entity.SymptomMapping;
import mediwise_backend.repository.DoctorRepository;
import mediwise_backend.repository.SymptomRepository;
import org.springframework.stereotype.Service;
import mediwise_backend.exception.SymptomNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SymptomMappingService {

    private final SymptomRepository symptomRepository;
    private final DoctorRepository doctorRepository;

    public List<Doctor> recommendDoctors(String symptom) {

        SymptomMapping mapping =
                symptomRepository.findBySymptomIgnoreCase(symptom)
                        .orElseThrow(() ->
                                new SymptomNotFoundException(symptom));

        return doctorRepository.findBySpecialization(mapping.getSpecialist());
    }
}