package no.jlwcrews.petclinic.appointment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    private final ObjectMapper mapper = new ObjectMapper();

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentDto appointmentDto) {
        return ResponseEntity.ok(appointmentService.createAppointment(appointmentDto));
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAppointments() {
        return ResponseEntity.ok(appointmentService.findAllAppointments());
    }
}
