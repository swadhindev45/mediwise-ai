package mediwise_backend.controller;

import lombok.RequiredArgsConstructor;
import mediwise_backend.service.SymptomMappingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SymptomMappingController {
    private final SymptomMappingService SymptomMappingService;

    @GetMapping("/recommend")
    public String recommend(
            @RequestParam String symptom){
        return SymptomMappingService
                .recommendSpecialist(symptom);

    }

}
