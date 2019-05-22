package Resort.Controllers.Buildings;

import Resort.Domain.Facilities.Building.TennisFacility;
import Resort.Factories.Facilities.TennisFactory;
import org.junit.Assert;
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

public class TennisControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/tennis";

    @Test
    public void create() {
        TennisFacility tennisFacility = TennisFactory.getTennisFacility("TestID","TestCourseName");
        System.out.println(tennisFacility);

        ResponseEntity<TennisFacility> postResponse = restTemplate.postForEntity(baseURL + "/create", tennisFacility, TennisFacility.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void read() {
        TennisFacility tennisName = restTemplate.getForObject(baseURL + "/read/216062241", TennisFacility.class);
        assertNotNull(tennisName);
    }

    @Test
    public void update() {
        int id =216062241;
        TennisFacility tennisName = restTemplate.getForObject(baseURL + "/216009529/" + id, TennisFacility.class);

        restTemplate.put(baseURL + "/216062241/" + id, tennisName);
        TennisFacility updatedAppointment = restTemplate.getForObject(baseURL + "/216009520/" + id, TennisFacility.class);
        assertNotNull(updatedAppointment);
    }

    @Test
    public void delete() {
        int id = 216062241;
        TennisFacility tennisName = restTemplate.getForObject(baseURL + "/tennisName/" + id,TennisFacility.class);
        assertNotNull(tennisName);
        restTemplate.delete(baseURL + "/golfID/" + id);
        try {
            tennisName = restTemplate.getForObject(baseURL + "/golfCourseName/" + id, TennisFacility.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}