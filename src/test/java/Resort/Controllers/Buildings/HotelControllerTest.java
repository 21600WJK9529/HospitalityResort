package Resort.Controllers.Buildings;

import Resort.Domain.Facilities.Building.GolfFacility;
import Resort.Factories.Facilities.GolfFactory;
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

public class HotelControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/hotel";

    @Test
    public void create() {
        GolfFacility golfFacility = GolfFactory.getGolfFacility("TestID","TestCourseName");
        System.out.println(golfFacility);

        ResponseEntity<GolfFacility> postResponse = restTemplate.postForEntity(baseURL + "/create", golfFacility, GolfFacility.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void read() {
        GolfFacility golfCourse = restTemplate.getForObject(baseURL + "/read/216062241", GolfFacility.class);
        assertNotNull(golfCourse);
    }

    @Test
    public void update() {
        int id =216062241;
        GolfFacility golfCourse = restTemplate.getForObject(baseURL + "/216009529/" + id, GolfFacility.class);

        restTemplate.put(baseURL + "/216062241/" + id, golfCourse);
        GolfFacility updatedAppointment = restTemplate.getForObject(baseURL + "/216009520/" + id, GolfFacility.class);
        assertNotNull(updatedAppointment);
    }

    @Test
    public void delete() {
        int id = 216062241;
        GolfFacility golfCourse = restTemplate.getForObject(baseURL + "/golfCourse/" + id,GolfFacility.class);
        assertNotNull(golfCourse);
        restTemplate.delete(baseURL + "/golfID/" + id);
        try {
            golfCourse = restTemplate.getForObject(baseURL + "/golfCourseName/" + id, GolfFacility.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}