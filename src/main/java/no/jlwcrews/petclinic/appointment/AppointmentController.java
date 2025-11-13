package no.jlwcrews.petclinic.appointment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/api/appointment")
public class AppointmentController {

    private final ObjectMapper mapper = new ObjectMapper();

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    }

    @PostMapping
    public String createAppointment(@RequestBody AppointmentDto appointmentDto, Model model) {
        var appt = appointmentService.createAppointment(appointmentDto);
        model.addAttribute("petName", appt.getPet().getName());
        model.addAttribute("date", appt.getDate());
        model.addAttribute("owner", appt.getPet().getOwner());
        model.addAttribute("staff", appt.getStaff());
        return "index";
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAppointments() {
        return ResponseEntity.ok(appointmentService.findAllAppointments());
    }

    @GetMapping("/owner/{id}")
    public ResponseEntity<List<Appointment>> getAppointmentsByOwner(@PathVariable("id") int id) {
        return ResponseEntity.ok(appointmentService.findAppointmentsByOwnerId(id));
    }
}
