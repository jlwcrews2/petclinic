package no.jlwcrews.petclinic.pet;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepo repo;

    public PetService(PetRepo repo) {
        this.repo = repo;
    }

    public List<Pet> findAll() {
        return repo.findAll();
    }

    public Pet findById(long id) {
        return repo.findById(id).orElse(null);
    }

    public Pet save(Pet pet) {
        return repo.save(pet);
    }

    public void deleteById(long id) {
        repo.deleteById(id);
    }
}
