package Resort.Controllers.Buildings;

import Resort.Domain.Facilities.Building.RestaurantFacility;
import Resort.Factories.Facilities.RestaurantFactory;
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

public class RestaurantControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/hotel";

    @Test
    public void create() {
        RestaurantFacility restaurantFacility = RestaurantFactory.getRestaurantFacility("TestID","TestCourseName");
        System.out.println(restaurantFacility);

        ResponseEntity<RestaurantFacility> postResponse = restTemplate.postForEntity(baseURL + "/create", restaurantFacility, RestaurantFacility.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void read() {
        RestaurantFacility restaurantName = restTemplate.getForObject(baseURL + "/read/216062241", RestaurantFacility.class);
        assertNotNull(restaurantName);
    }

    @Test
    public void update() {
        int id =216062241;
        RestaurantFacility restaurantName = restTemplate.getForObject(baseURL + "/216009529/" + id, RestaurantFacility.class);

        restTemplate.put(baseURL + "/216062241/" + id, restaurantName);
        RestaurantFacility updatedAppointment = restTemplate.getForObject(baseURL + "/216009520/" + id, RestaurantFacility.class);
        assertNotNull(updatedAppointment);
    }

    @Test
    public void delete() {
        int id = 216062241;
        RestaurantFacility restaurantName = restTemplate.getForObject(baseURL + "/restaurantName/" + id,RestaurantFacility.class);
        assertNotNull(restaurantName);
        restTemplate.delete(baseURL + "/golfID/" + id);
        try {
            restaurantName = restTemplate.getForObject(baseURL + "/golfCourseName/" + id, RestaurantFacility.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}