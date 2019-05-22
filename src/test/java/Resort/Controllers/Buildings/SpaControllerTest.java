package Resort.Controllers.Buildings;

import Resort.Domain.Facilities.Building.SpaFacility;
import Resort.Factories.Facilities.SpaFactory;
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

public class SpaControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/spa";

    @Test
    public void create() {
        SpaFacility golfFacility = SpaFactory.getSpaFacility("TestID","TestCourseName");
        System.out.println(golfFacility);

        ResponseEntity<SpaFacility> postResponse = restTemplate.postForEntity(baseURL + "/create", golfFacility, SpaFacility.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void read() {
        SpaFacility spaName = restTemplate.getForObject(baseURL + "/read/216062241", SpaFacility.class);
        assertNotNull(spaName);
    }

    @Test
    public void update() {
        int id =216062241;
        SpaFacility spaName = restTemplate.getForObject(baseURL + "/216009529/" + id, SpaFacility.class);

        restTemplate.put(baseURL + "/216062241/" + id, spaName);
        SpaFacility updatedAppointment = restTemplate.getForObject(baseURL + "/216009520/" + id, SpaFacility.class);
        assertNotNull(updatedAppointment);
    }

    @Test
    public void delete() {
        int id = 216062241;
        SpaFacility spaName = restTemplate.getForObject(baseURL + "/spaName/" + id,SpaFacility.class);
        assertNotNull(spaName);
        restTemplate.delete(baseURL + "/golfID/" + id);
        try {
            spaName = restTemplate.getForObject(baseURL + "/golfCourseName/" + id, SpaFacility.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}