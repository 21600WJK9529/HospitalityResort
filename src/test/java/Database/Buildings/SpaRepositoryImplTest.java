package Database.Buildings;

import Facilities.Building.SpaFacility;
import org.junit.Before;
import org.junit.Test;

import static Factories.Facilities.SpaFactory.getSpaFacility;
import static org.junit.Assert.*;

public class SpaRepositoryImplTest {
    SpaRepositoryImpl spa;
    @Before
    public void setUp() throws Exception {
        spa = (SpaRepositoryImpl) SpaRepositoryImpl.getRepository();
    }
    @Test
    public void create() {
        SpaFacility x= getSpaFacility("TestName");
        spa.create(x);
        assertNotNull(spa.getAll());
        System.out.println(spa.getAll());
    }

    @Test
    public void read() {
        SpaFacility x= getSpaFacility("TestName");
        spa.create(x);
        assertNotNull(spa.read("TestName"));
        System.out.println(spa.getAll());
    }

    @Test
    public void update() {
        SpaFacility x= getSpaFacility("TestName");
        spa.create(x);
        System.out.println(spa.getAll());
        SpaFacility xUpdate=getSpaFacility("TestNameUpdated");
        spa.update(xUpdate);
        assertEquals(xUpdate,spa.read("TestID"));
        System.out.println(spa.getAll());
    }

    @Test
    public void delete() {
        SpaFacility x= getSpaFacility("TestName");
        spa.create(x);
        System.out.println(spa.getAll());
        spa.delete("TestName");
        System.out.println(spa.getAll());
    }

}