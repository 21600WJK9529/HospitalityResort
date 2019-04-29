package Database.Buildings;

import Facilities.Building.GolfFacility;
import org.junit.Before;
import org.junit.Test;

import static Factories.Facilities.GolfFactory.getGolfFacility;
import static org.junit.Assert.*;

public class GolfRepositoryImplTest {
GolfRepositoryImpl golf;
    @Before
    public void setUp() throws Exception {
        golf = (GolfRepositoryImpl) GolfRepositoryImpl.getRepository();
    }
    @Test
    public void create() {
        GolfFacility x= getGolfFacility("TestName");
        golf.create(x);
        assertNotNull(golf.getAll());
        System.out.println(golf.getAll());
    }

    @Test
    public void read() {
        GolfFacility x= getGolfFacility("TestName");
        golf.create(x);
        assertNotNull(golf.read("TestName"));
        System.out.println(golf.getAll());  
    }

    @Test
    public void update() {
        GolfFacility x= getGolfFacility("TestName");
        golf.create(x);
        System.out.println(golf.getAll());
        GolfFacility xUpdate=getGolfFacility("TestNameUpdated");
        golf.update(xUpdate);
        assertEquals(xUpdate,golf.read("TestID"));
        System.out.println(golf.getAll());
    }

    @Test
    public void delete() {
        GolfFacility x= getGolfFacility("TestName");
        golf.create(x);
        System.out.println(golf.getAll());
        golf.delete("TestName");
        System.out.println(golf.getAll());
    }
}