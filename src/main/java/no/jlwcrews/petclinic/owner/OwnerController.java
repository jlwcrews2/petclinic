package no.jlwcrews.petclinic.owner;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<List<Owner>> getOwners() {
        return ResponseEntity.ok(ownerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable long id) {
        return ResponseEntity.ok(ownerService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        return ResponseEntity.ok(ownerService.save(owner));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable long id) {
        ownerService.deleteById(id);
        return ResponseEntity.ok("Owner Deleted");
    }
}
