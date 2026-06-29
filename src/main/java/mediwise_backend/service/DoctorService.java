package mediwise_backend.service;

import mediwise_backend.entity.Doctor;
import mediwise_backend.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import mediwise_backend.repository.SymptomRepository;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor updateDoctor(long id, Doctor doctor){
        Doctor newDoctor = doctorRepository.findById(id).orElseThrow();
        newDoctor.setCity(doctor.getCity());
        newDoctor.setName(doctor.getName());
        newDoctor.setExperience(doctor.getExperience());
        newDoctor.setSpecialization(doctor.getSpecialization());
        newDoctor.setConsultationFee(doctor.getConsultationFee());
        newDoctor.setHospitalName(doctor.getHospitalName());
        return doctorRepository.save(newDoctor);
    }

    public void deleteDoctor(long id){
        doctorRepository.deleteById(id);
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }


}