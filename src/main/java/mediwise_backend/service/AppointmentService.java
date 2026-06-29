package mediwise_backend.service;

import lombok.RequiredArgsConstructor;
import mediwise_backend.dto.AppointmentRequest;
import mediwise_backend.entity.Appointment;
import mediwise_backend.entity.Doctor;
import mediwise_backend.repository.AppointmentRepository;
import mediwise_backend.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    public Appointment bookAppointment(AppointmentRequest request) {

        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Appointment appointment = new Appointment();

        appointment.setDoctor(doctor);
        appointment.setAppointmentDate(request.getAppointmentDate());
        appointment.setAppointmentTime(request.getAppointmentTime());

        // Temporary until authentication is added
        appointment.setUser(null);

        appointment.setStatus("PENDING");

        return appointmentRepository.save(appointment);
    }
}