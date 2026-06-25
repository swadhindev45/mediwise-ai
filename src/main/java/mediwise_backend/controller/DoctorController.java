package mediwise_backend.controller;

import lombok.RequiredArgsConstructor;
import mediwise_backend.entity.Doctor;
import mediwise_backend.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping()
    public Doctor saveDoctor(@RequestBody Doctor doctor){
        return doctorService.saveDoctor(doctor);
    }

    @GetMapping
    public List<Doctor> getDoctor(){
        return doctorService.getAllDoctors();
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(
            @PathVariable long id,
            @RequestBody Doctor doctor
    ){
        return doctorService.updateDoctor(id,doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(
            @PathVariable long id
    ){
        doctorService.deleteDoctor(id);
    }
}
