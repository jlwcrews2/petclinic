package no.jlwcrews.petclinic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StaffIT extends BaseIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldCreateStaff() throws Exception {
        var newStaff = """
                    {
                    "firstName": "Giant",
                    "lastName": "Penguin",
                    "staffType": "VETERINARIAN"}
                """;

        mvc.perform(post("/api/staff")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newStaff))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value("Giant"));

    }
}
