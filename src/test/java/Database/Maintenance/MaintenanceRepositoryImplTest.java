package Database.Maintenance;

import Register.MaintenanceRegister;
import org.junit.Before;
import org.junit.Test;

import static Factories.Register.MaintenanceFactory.getMaintenanceRegister;
import static org.junit.Assert.*;

public class MaintenanceRepositoryImplTest {
MaintenanceRepositoryImpl maintenance;
    @Before
    public void setUp() throws Exception {
        maintenance = (MaintenanceRepositoryImpl) MaintenanceRepositoryImpl.getRepository();
    }
    @Test
    public void create() {
        MaintenanceRegister x=getMaintenanceRegister("TestID", "TestFName", "TestLName","x@x.com","Hotel", "Test08332123");

        maintenance.create(x);
        assertNotNull(maintenance.getAll());
        System.out.println(maintenance.getAll());
    }

    @Test
    public void read() {
        MaintenanceRegister x=getMaintenanceRegister("TestID", "TestFName", "TestLName","x@x.com","Hotel", "Test08332123");
        maintenance.create(x);
        assertNotNull(maintenance.read("TestID"));
        System.out.println(maintenance.getAll());
    }

    @Test
    public void update() {
        MaintenanceRegister x=getMaintenanceRegister("TestID", "TestFName", "TestLName","TestEmailx@x.com","TestFacilityHotel", "TestTwo08332123");
        maintenance.create(x);
        System.out.println(maintenance.getAll());
        MaintenanceRegister xUpdate=getMaintenanceRegister("TestID", "TestFName2", "TestLName2","TestEmail2x@x.com","TestFacility2Hotel", "TestTwo08332123");
        maintenance.update(xUpdate);
        assertEquals(xUpdate,maintenance.read("TestID"));
        System.out.println(maintenance.getAll());
    }

    @Test
    public void delete() {
        MaintenanceRegister x=getMaintenanceRegister("TestID", "TestFName2", "TestLName2","x@x.com","Hotel", "TestTwo08332123");
        maintenance.create(x);
        System.out.println(maintenance.getAll());
        maintenance.delete("TestID");
        assertNull(maintenance.read("TestID"));
        System.out.println(maintenance.getAll());
    }
}