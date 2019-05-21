package Resort.Factories;

import Resort.Factories.Register.UserFactory;
import Resort.Domain.Register.UserRegister;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserFactoryTest {

    @Test
    public void getUserRegister() {
        UserRegister user= UserFactory.getUserRegister("A1","A","B","1231321");
        System.out.println(user);
        assertNotNull(user);
    }
}