package no.jlwcrews.petclinic.staff;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepo repo;

    public StaffService(StaffRepo repo) {
        this.repo = repo;
    }

    public List<Staff> findAll() {
        return repo.findAll();
    }

    public Staff findById(long id) {
        return repo.findById(id).orElse(null);
    }

    public Staff save(Staff staff) {
        return repo.save(staff);
    }

    public void deleteById(long id) {
        repo.deleteById(id);
    }
}
