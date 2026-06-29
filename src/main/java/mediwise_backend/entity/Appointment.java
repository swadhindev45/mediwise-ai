package mediwise_backend.entity;
import mediwise_backend.enums.AppointmentStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static javax.management.openmbean.SimpleType.STRING;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate appointmentDate;

    private LocalTime appointmentTime;

   @Enumerated(EnumType.STRING)
   private AppointmentStatusEnum status;


    @ManyToOne
    private User user;

    @ManyToOne
    private Doctor doctor;
}
