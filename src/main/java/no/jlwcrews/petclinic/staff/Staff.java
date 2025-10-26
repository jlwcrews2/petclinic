package no.jlwcrews.petclinic.staff;

import jakarta.persistence.*;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_gen")
    @SequenceGenerator(name = "staff_gen", sequenceName = "staff_seq", allocationSize = 1)
    @Column(name = "id")
    private Long staffId;
    private String firstName;
    private String lastName;
    private StaffType staffType;

    public Staff(String firstName, String lastName, StaffType staffType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.staffType = staffType;
    }

    public Staff() {
    }

    public Long getId() {
        return staffId;
    }

    public void setId(Long staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public StaffType getStaffType() {
        return staffType;
    }

    public void setStaffType(StaffType staffType) {
        this.staffType = staffType;
    }
}
