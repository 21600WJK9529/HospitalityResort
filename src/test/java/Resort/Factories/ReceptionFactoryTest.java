package Resort.Factories;

import Resort.Factories.Register.ReceptionFactory;
import Resort.Domain.Register.ReceptionRegister;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReceptionFactoryTest {

    @Test
    public void getReceptionRegister() {
        ReceptionRegister reception= ReceptionFactory.getReceptionRegister("ASF123","June","Doe","x@fsd.com",
                                                                                                            "Hotel","1231423");
        System.out.println(reception);
        assertNotNull(reception);
    }
}