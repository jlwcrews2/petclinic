package no.jlwcrews.petclinic.init;

import com.github.javafaker.Faker;
import no.jlwcrews.petclinic.owner.Owner;
import no.jlwcrews.petclinic.owner.OwnerService;
import no.jlwcrews.petclinic.pet.Pet;
import no.jlwcrews.petclinic.pet.PetService;
import no.jlwcrews.petclinic.pet.PetType;
import no.jlwcrews.petclinic.staff.Staff;
import no.jlwcrews.petclinic.staff.StaffService;
import no.jlwcrews.petclinic.staff.StaffType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@RestController
@RequestMapping("/api/init")
public class InitialDataController {

    private final PetService petService;
    private final StaffService staffService;
    private final OwnerService ownerService;
    private final Random random = new Random();
    private final Faker faker = new Faker();

    public InitialDataController(PetService petService, StaffService staffService, OwnerService ownerService) {
        this.petService = petService;
        this.staffService = staffService;
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<String> init() {
        for (int i = 0; i < 10; i++) {
            var petList = new ArrayList<Pet>();
            var randomNumberOfPets = random.nextInt(3) + 1;
            var owner = ownerService.save(new Owner(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.address().streetAddress(),
                    faker.phoneNumber().phoneNumber(),
                    null
            ));
            for (int j = 0; j < randomNumberOfPets; j++) {
                var pet = generateNewPet(owner);
                petList.add(pet);
            }
            owner.setPets(petList);
            ownerService.save(owner);
        }

        for (int i = 0; i < 8; i++) {
            var type = switch (random.nextInt(3)) {
                case 0 -> StaffType.NURSE;
                case 1 -> StaffType.VETERINARIAN;
                case 2 -> StaffType.ADMIN;
                default -> null;
            };
            staffService.save(new Staff(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    type));
        }

        return ResponseEntity.ok("Data initialized");
    }

    private Pet generateNewPet(Owner owner) {
        var pet = switch (random.nextInt(3)) {
            case 0 -> new Pet(StringUtils.capitalize(faker.cat().name()), PetType.CAT, owner);
            case 1 -> new Pet(StringUtils.capitalize(faker.dog().name()), PetType.DOG, owner);
            case 2 -> new Pet(StringUtils.capitalize(faker.animal().name()), PetType.BIRD, owner);
            default -> null;
        };
        return petService.save(pet);
    }
}
