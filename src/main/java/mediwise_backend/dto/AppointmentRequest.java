package mediwise_backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
public class AppointmentRequest {
    private Long doctorId;

    private String patientName;

    private String email;

    private String phone;

    private LocalDate appointmentDate;

    private LocalTime appointmentTime;
}
