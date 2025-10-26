package no.jlwcrews.petclinic.owner;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    private final no.jlwcrews.petclinic.owner.OwnerRepo repo;

    public OwnerService(OwnerRepo repo) {
        this.repo = repo;
    }

    public List<Owner> findAll() {
        return repo.findAll();
    }

    public Owner findById(long id) {
        return repo.findById(id).orElse(null);
    }

    public Owner save(Owner Owner) {
        return repo.save(Owner);
    }

    public void deleteById(long id) {
        repo.deleteById(id);
    }
}
