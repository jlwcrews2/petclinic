package no.jlwcrews.petclinic.appointment;

import jakarta.persistence.*;
import no.jlwcrews.petclinic.pet.Pet;
import no.jlwcrews.petclinic.staff.Staff;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appt_gen")
    @SequenceGenerator(name = "appt_gen", sequenceName = "appointment_seq", allocationSize = 1)
    @Column(name = "appointment_id")
    private Long id;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToMany
    @JoinTable(
            name = "appointment_staff",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id")
    )
    private List<Staff> staff;

    public Appointment(List<Staff> staff, Pet pet, LocalDate date) {
        this.staff = staff;
        this.pet = pet;
        this.date = date;
    }

    public Appointment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }
}
