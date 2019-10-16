//package Resort.Domain.Reception;
//
//import Resort.Domain.Register.Reception.ReceptionRegister;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//import static Resort.Factories.Register.ReceptionFactory.getReceptionRegister;
//public class ReceptionRepositoryImplTest {
//ReceptionRepositoryImpl reception;
//
//    @Before
//    public void setUp() throws Exception {
//        reception = (ReceptionRepositoryImpl) ReceptionRepositoryImpl.getRepository();
//    }
//    @Test
//    public void create() {
//        ReceptionRegister x = getReceptionRegister("TestID", "TestFName", "TestLName", "TestX@X.com","TestRestuaurant","Test0813846513");
//
//        reception.create(x);
//        assertNotNull(reception.getAll());
//        System.out.println(reception.getAll());
//    }
//
//    @Test
//    public void read() {
//        ReceptionRegister x= getReceptionRegister("TestID", "TestFName", "TestLName", "TestX@X.com","TestRestuaurant","Test0813846513");
//        reception.create(x);
//        assertNotNull(reception.read("TestID"));
//        System.out.println(reception.getAll());
//    }
//
//    @Test
//    public void update() {
//        ReceptionRegister x= getReceptionRegister("TestID", "TestFName", "TestLName", "TestX@X.com","TestRestuaurant","Test0813846513");
//        reception.create(x);
//        System.out.println(reception.getAll());
//        ReceptionRegister xUpdate= getReceptionRegister("TestID", "TestFName2", "TestLName2", "TestX@X.com2","TestRestuaurant2","TestTwo0813846513");
//        reception.update(xUpdate);
//        assertEquals(xUpdate,reception.read("TestID"));
//        System.out.println(reception.getAll());
//    }
//
//    @Test
//    public void delete() {
//        ReceptionRegister x= getReceptionRegister("TestID", "TestFName", "TestLName", "TestX@X.com","TestRestuaurant","Test0813846513");
//        reception.create(x);
//        System.out.println(reception.getAll());
//        reception.delete("TestID");
//        assertNull(reception.read("TestID"));
//        System.out.println(reception.getAll());
//    }
//}