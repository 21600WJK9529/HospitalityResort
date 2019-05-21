package Resort.Factories;

import Resort.Factories.Register.ReceptionFactory;
import Resort.Domain.Register.ReceptionRegister;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReceptionFactoryTest {

    @Test
    public void getReceptionRegister() {
        ReceptionRegister reception= ReceptionFactory.getUserRegister("ASF123","June","Doe","x@fsd.com",
                                                                                                            "Hotel",87945123);
        System.out.println(reception);
        assertNotNull(reception);
    }
}