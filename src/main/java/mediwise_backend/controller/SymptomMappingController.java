package mediwise_backend.controller;

import lombok.RequiredArgsConstructor;
import mediwise_backend.entity.Doctor;
import mediwise_backend.service.SymptomMappingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.Doc;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SymptomMappingController {
    private final SymptomMappingService SymptomMappingService;

    @GetMapping("/recommend")
    public List<Doctor> recommend(
            @RequestParam String symptom){
        String Symptoms = symptom.toLowerCase().trim();
        return SymptomMappingService
                .recommendDoctors(Symptoms);

    }

}
