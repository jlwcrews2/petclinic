package no.jlwcrews.petclinic.staff;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class StaffServiceTest {

    @MockitoBean
    private StaffRepo repo;

    @Autowired
    private StaffService service;

    @Test
    void shouldFindAll() {
        Staff vet = new Staff(
            "Jason",
            "Walrus",
            StaffType.VETERINARIAN
        );
        when(repo.findAll()).thenReturn(List.of(vet));
        List<Staff> staff = service.findAll();
        assert staff != null;
        assert staff.size() == 1;
        staff.forEach(System.out::println);
    }
}
