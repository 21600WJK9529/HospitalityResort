package Resort.Security;

import Resort.Domain.Register.MaintenanceRegister;
import Resort.Factories.Register.MaintenanceFactory;
import Resort.Services.people.MaintenanceServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HospitalityResortSecurityTest {
    private static final String BASE_URL = "http://localhost:8080/HospitalityResort/lookup/maintenance";

    @Autowired
    private TestRestTemplate restTemplate;
    private MaintenanceServiceImpl service;

    @Test
    public void createRace() {
        MaintenanceRegister createMaintenanceRegister;
        createMaintenanceRegister = MaintenanceFactory.getMaintenanceRegister("id","fname", "lname","email","facility","phoneNo");

        ResponseEntity<String> result = this.restTemplate.withBasicAuth("admin", "admin")
                .postForEntity(BASE_URL + "/create/createMaintenanceRegister", createMaintenanceRegister, String.class);
        System.out.println(result.getBody());
        assertEquals(200, result.getStatusCodeValue());
    }
}
