package Resort.Controllers.Users;

import Resort.Domain.Register.ReceptionRegister;
import Resort.Factories.Register.ReceptionFactory;
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

public class ReceptionControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/reception";

    @Test
    public void create() {
        ReceptionRegister receptRegister =
                ReceptionFactory.getReceptionRegister("TestID",
                        "TestCourseFName",
                        "TestCourselName",
                        "TestEmail",
                        "FacilityTest",
                        "TestPhone");
        System.out.println(receptRegister);

        ResponseEntity<ReceptionRegister> postResponse = restTemplate.postForEntity(baseURL + "/create", receptRegister, ReceptionRegister.class);
        assertNotNull(postResponse);
        //assertNotNull(postResponse.getBody());
    }

    @Test
    public void read() {
        ReceptionRegister receptRegister = restTemplate.getForObject(baseURL + "/read/216062241", ReceptionRegister.class);
        assertNotNull(receptRegister);
    }

    @Test
    public void update() {
        int id =216062241;
        ReceptionRegister receptRegister = restTemplate.getForObject(baseURL + "/216009529/" + id, ReceptionRegister.class);

        restTemplate.put(baseURL + "/216062241/" + id, receptRegister);
        ReceptionRegister updatedAppointment = restTemplate.getForObject(baseURL + "/216009520/" + id, ReceptionRegister.class);
        assertNotNull(updatedAppointment);
    }

    @Test
    public void delete() {
        int id = 216062241;
        ReceptionRegister receptRegister = restTemplate.getForObject(baseURL + "/receptRegister/" + id,ReceptionRegister.class);
        assertNotNull(receptRegister);
        restTemplate.delete(baseURL + "/maintenanceID/" + id);
        try {
            receptRegister = restTemplate.getForObject(baseURL + "/getMaintenanceName/" + id, ReceptionRegister.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}