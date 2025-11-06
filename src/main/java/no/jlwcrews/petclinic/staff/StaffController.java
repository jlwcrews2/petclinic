package no.jlwcrews.petclinic.staff;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Staff>> getStaffs() {
        return ResponseEntity.ok(staffService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaff(@PathVariable long id) {
        return ResponseEntity.ok(staffService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
        return ResponseEntity.ok(staffService.save(staff));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable long id) {
        staffService.deleteById(id);
        return ResponseEntity.ok("Staff Deleted");
    }
}
