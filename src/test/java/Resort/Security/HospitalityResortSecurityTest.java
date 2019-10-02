package Resort.Security;

import Resort.Domain.Register.Maintenance.MaintenanceRegister;
import Resort.Factories.Register.MaintenanceFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HospitalityResortSecurityTest {
    private static final String BASE_URL = "http://localhost:8080/HospitalityResort/maintenance";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void create() {
        MaintenanceRegister maintenanceRegister = MaintenanceFactory.getMaintenanceRegister("id","fName", "lName","email","facility","phoneNo");
        ResponseEntity result = restTemplate.withBasicAuth("admin", "admin")
                .postForEntity(BASE_URL + "/create/maintenanceRegister", maintenanceRegister, Object.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void read() {
        ResponseEntity<String> result = restTemplate.withBasicAuth("admin", "admin")
                .getForEntity(BASE_URL+"/read/id", String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void update(){
        MaintenanceRegister maintenanceRegister = MaintenanceFactory.getMaintenanceRegister("newId","newFName", "newLName","newEmail","newFacility","newPhoneNo");
        ResponseEntity result = restTemplate.withBasicAuth("admin", "admin")
                .postForEntity(BASE_URL+"/update/maintenanceRegister", maintenanceRegister, Object.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void delete() {
        ResponseEntity result = restTemplate.withBasicAuth("admin", "admin")
                .getForEntity(BASE_URL+"/delete/newId", String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
