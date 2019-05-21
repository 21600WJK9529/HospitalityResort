package Resort.Factories;

import Resort.Factories.Register.MaintenanceFactory;
import Resort.Domain.Register.MaintenanceRegister;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaintenanceFactoryTest {

    @Test
    public void getUserRegister() {
        MaintenanceRegister maintenance= MaintenanceFactory.getMaintenanceRegister("ASF123","June","Doe","x@fsd.com",
                "Hotel","87945123");
        System.out.println(maintenance);
        assertNotNull(maintenance);
    }
}