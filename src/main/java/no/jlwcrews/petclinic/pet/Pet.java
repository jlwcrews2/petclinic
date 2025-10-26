package no.jlwcrews.petclinic.pet;

import jakarta.persistence.*;
import no.jlwcrews.petclinic.owner.Owner;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_gen")
    @SequenceGenerator(name = "pet_gen", sequenceName = "pet_seq", allocationSize = 1)
    @Column(name = "id")
    private Long petId;
    private String name;
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Pet(String name, PetType petType, Owner owner) {
        this.name = name;
        this.petType = petType;
        this.owner = owner;
    }

    public Pet() {

    }

    public Long getId() {
        return petId;
    }

    public void setId(Long petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
