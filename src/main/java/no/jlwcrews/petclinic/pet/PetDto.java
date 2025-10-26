package no.jlwcrews.petclinic.pet;

public record PetDto(
        String name,
        PetType type,
        long ownerId
) {

}
