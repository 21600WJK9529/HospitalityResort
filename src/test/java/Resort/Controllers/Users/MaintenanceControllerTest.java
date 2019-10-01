package Resort.Controllers.Users;

import Resort.Domain.Register.Maintenance.MaintenanceRegister;
import Resort.Factories.Register.MaintenanceFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class MaintenanceControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/maintenance";

    @Test
    public void create() {
        MaintenanceRegister mainRegister =
                MaintenanceFactory.getMaintenanceRegister("TestID",
                        "TestCourseFName",
                        "TestCourselName",
                        "TestEmail",
                        "GolfTest",
                        "TestPhone");
        System.out.println(mainRegister);

        ResponseEntity<MaintenanceRegister> postResponse = restTemplate.postForEntity(baseURL + "/create", mainRegister, MaintenanceRegister.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void read() {
        MaintenanceRegister mainRegister = restTemplate.getForObject(baseURL + "/read/216062241", MaintenanceRegister.class);
        assertNotNull(mainRegister);
    }

    @Test
    public void update() {
        int id =216062241;
        MaintenanceRegister mainRegister = restTemplate.getForObject(baseURL + "/216009529/" + id, MaintenanceRegister.class);

        restTemplate.put(baseURL + "/216062241/" + id, mainRegister);
        MaintenanceRegister updatedAppointment = restTemplate.getForObject(baseURL + "/216009520/" + id, MaintenanceRegister.class);
        assertNotNull(updatedAppointment);
    }

    @Test
    public void delete() {
        int id = 216062241;
        MaintenanceRegister mainRegister = restTemplate.getForObject(baseURL + "/mainRegister/" + id,MaintenanceRegister.class);
        assertNotNull(mainRegister);
        restTemplate.delete(baseURL + "/maintenanceID/" + id);
        try {
            mainRegister = restTemplate.getForObject(baseURL + "/getMaintenanceName/" + id, MaintenanceRegister.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}