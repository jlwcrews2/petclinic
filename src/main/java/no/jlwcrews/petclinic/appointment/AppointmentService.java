package no.jlwcrews.petclinic.appointment;

import no.jlwcrews.petclinic.pet.PetService;
import no.jlwcrews.petclinic.staff.Staff;
import no.jlwcrews.petclinic.staff.StaffService;
import no.jlwcrews.petclinic.staff.StaffType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AppointmentService {

    private final PetService petService;
    private final StaffService staffService;
    private final AppointmentRepo repo;
    private final Random rand = new Random();

    public AppointmentService(PetService petService, StaffService staffService, AppointmentRepo repo) {
        this.petService = petService;
        this.staffService = staffService;
        this.repo = repo;
    }

    public Appointment createAppointment(AppointmentDto appointmentDto) {
        var staffList = staffService.findAll();
        var vetList = staffList.stream().filter(s -> s.getStaffType().equals(StaffType.VETERINARIAN)).toList();
        var nurseList = staffList.stream().filter(s -> s.getStaffType().equals(StaffType.NURSE)).toList();
        var pet = petService.findById(appointmentDto.petId());

        return repo.save(new Appointment(
                generateStaff(vetList, nurseList),
                pet,
                appointmentDto.appointmentDate()
        ));
    }

    public List<Appointment> findAllAppointments() {
        return repo.findAll();
    }

    private List<Staff> generateStaff(List<Staff> vetList, List<Staff> nurseList) {
        var vet = vetList.get(rand.nextInt(vetList.size()));
        var nurse = nurseList.get(rand.nextInt(nurseList.size()));
        return List.of(vet, nurse);
    }

    public List<Appointment> findAppointmentsByOwnerId(long ownerId) {
        return repo.findAppointmentsByOwnerIdNative(ownerId);
    }

}
