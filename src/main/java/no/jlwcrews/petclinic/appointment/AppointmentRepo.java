package no.jlwcrews.petclinic.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

    @Query(value = """
    SELECT a.*
    FROM appointment a
    JOIN pet p ON a.pet_id = p.id
    WHERE p.owner_id = :ownerId
    """, nativeQuery = true)
    List<Appointment> findAppointmentsByOwnerIdNative(@Param("ownerId") Long ownerId);
}
