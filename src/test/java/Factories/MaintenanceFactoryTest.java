package Factories;

import Factories.Register.MaintenanceFactory;
import Register.MaintenanceRegister;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaintenanceFactoryTest {

    @Test
    public void getUserRegister() {
        MaintenanceRegister maintenance= MaintenanceFactory.getUserRegister("ASF123","June","Doe","x@fsd.com",
                "Hotel",87945123);
        System.out.println(maintenance);
        assertNotNull(maintenance);
    }
}