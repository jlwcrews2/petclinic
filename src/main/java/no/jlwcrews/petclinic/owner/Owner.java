package no.jlwcrews.petclinic.owner;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import no.jlwcrews.petclinic.pet.Pet;

import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_gen")
    @SequenceGenerator(name = "owner_gen", sequenceName = "owner_seq", allocationSize = 1)
    @Column(name = "id")
    private Long ownerId;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    @OneToMany(mappedBy = "owner")
    @JsonIgnoreProperties("owner")
    private List<Pet> pets;

    public Owner(String firstName, String lastName, String address, String phone, List<Pet> pets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.pets = pets;
    }

    public Owner() {

    }

    public Long getId() {
        return ownerId;
    }

    public void setId(Long ownerId) {
        this.ownerId = ownerId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
