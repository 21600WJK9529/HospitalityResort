package Resort.Controllers.Users;

import Resort.Domain.Register.User.UserRegister;
import Resort.Factories.Register.UserFactory;
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

public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/reception";

    @Test
    public void create() {
        UserRegister userRegister =
                UserFactory.getUserRegister("TestID",
                        "TestCourseFName",
                        "TestCourselName",
                        "TestPhone");
        System.out.println(userRegister);

        ResponseEntity<UserRegister> postResponse = restTemplate.postForEntity(baseURL + "/create", userRegister, UserRegister.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void read() {
        UserRegister userRegister = restTemplate.getForObject(baseURL + "/read/216062241", UserRegister.class);
        assertNotNull(userRegister);
    }

    @Test
    public void update() {
        int id =216062241;
        UserRegister userRegister = restTemplate.getForObject(baseURL + "/216009529/" + id, UserRegister.class);

        restTemplate.put(baseURL + "/216062241/" + id, userRegister);
        UserRegister updatedAppointment = restTemplate.getForObject(baseURL + "/216009520/" + id, UserRegister.class);
        assertNotNull(updatedAppointment);
    }

    @Test
    public void delete() {
        int id = 216062241;
        UserRegister userRegister = restTemplate.getForObject(baseURL + "/userRegister/" + id, UserRegister.class);
        assertNotNull(userRegister);
        restTemplate.delete(baseURL + "/maintenanceID/" + id);
        try {
            userRegister = restTemplate.getForObject(baseURL + "/getRegisterName/" + id, UserRegister.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}