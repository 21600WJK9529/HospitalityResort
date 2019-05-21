package Resort.Domain.Buildings;

import Resort.Domain.Facilities.Building.GolfFacility;
import org.junit.Before;
import org.junit.Test;

import static Resort.Factories.Facilities.GolfFactory.getGolfFacility;
import static org.junit.Assert.*;

public class GolfRepositoryImplTest {
GolfRepositoryImpl golf;
    @Before
    public void setUp() throws Exception {
        golf = (GolfRepositoryImpl) GolfRepositoryImpl.getRepository();
    }
    @Test
    public void create() {
        GolfFacility x= getGolfFacility("TestID", "TestName");
        golf.create(x);
        assertNotNull(golf.getAll());
        System.out.println(golf.getAll());
    }

    @Test
    public void read() {
        GolfFacility x= getGolfFacility("TestID", "TestName");
        golf.create(x);
        assertNotNull(golf.read("TestID"));
        System.out.println(golf.getAll());  
    }

    @Test
    public void update() {
        GolfFacility x= getGolfFacility("TestID", "TestName");
        golf.create(x);
        System.out.println(golf.getAll());
        GolfFacility xUpdate=getGolfFacility("TestID", "TestName2");
        golf.update(xUpdate);
        assertEquals(xUpdate,golf.read("TestID"));
        System.out.println(golf.getAll());
    }

    @Test
    public void delete() {

        GolfFacility x= getGolfFacility("TestID", "TestName");
        golf.create(x);
        System.out.println(golf.getAll());
        golf.delete("TestName");
        System.out.println(golf.getAll());
    }
}