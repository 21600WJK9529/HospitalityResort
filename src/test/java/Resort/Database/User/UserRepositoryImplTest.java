package Resort.Database.User;

import Resort.Domain.Register.UserRegister;
import org.junit.Before;
import org.junit.Test;

import static Resort.Factories.Register.UserFactory.getUserRegister;
import static org.junit.Assert.*;

public class UserRepositoryImplTest {
UserRepositoryImpl users;

    @Before
    public void setUp() throws Exception {
        users = (UserRepositoryImpl) UserRepositoryImpl.getRepository();
    }
    @Test
    public void create() {
        UserRegister x= getUserRegister("TestID", "TestFName", "TestLName", "Test08332123");

        users.create(x);
        assertNotNull(users.getAll());
        System.out.println(users.getAll());
    }

    @Test
    public void read() {
        UserRegister x= getUserRegister("TestID", "TestFName", "TestLName", "Test08332123");
        users.create(x);
        assertNotNull(users.read("TestID"));
        System.out.println(users.getAll());
    }

    @Test
    public void update() {
        UserRegister x= getUserRegister("TestID", "TestFName", "TestLName", "Test08332123");
        users.create(x);
        System.out.println(users.getAll());
        UserRegister xUpdate=getUserRegister("TestID", "TestFName2", "TestLName2", "TestTwo08332123");
        users.update(xUpdate);
        assertEquals(xUpdate,users.read("TestID"));
        System.out.println(users.getAll());
    }

    @Test
    public void delete() {
        UserRegister x= getUserRegister("TestID", "TestFName", "TestLName", "Test08332123");
        users.create(x);
        System.out.println(users.getAll());
        users.delete("TestID");
        assertNull(users.read("TestID"));
        System.out.println(users.getAll());
    }


}