package mediwise_backend.controller;

import lombok.RequiredArgsConstructor;
import mediwise_backend.dto.AppointmentRequest;
import mediwise_backend.entity.Appointment;
import mediwise_backend.service.AppointmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public Appointment bookAppointment(
            @RequestBody AppointmentRequest request) {

        return appointmentService.bookAppointment(request);
    }
}