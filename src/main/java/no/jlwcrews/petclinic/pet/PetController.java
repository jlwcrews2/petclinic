package no.jlwcrews.petclinic.pet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pet")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getPets() {
        return ResponseEntity.ok(petService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable long id) {
        return ResponseEntity.ok(petService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        return ResponseEntity.ok(petService.save(pet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePet(@PathVariable long id) {
        petService.deleteById(id);
        return ResponseEntity.ok("Pet Deleted");
    }
}
