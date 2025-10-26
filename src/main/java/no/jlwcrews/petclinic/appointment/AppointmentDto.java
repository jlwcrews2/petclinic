package no.jlwcrews.petclinic.appointment;

import java.time.LocalDate;

public record AppointmentDto(
        Long petId,
        LocalDate appointmentDate) {
}
