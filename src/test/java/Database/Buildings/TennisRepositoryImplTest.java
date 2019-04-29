package Database.Buildings;

import Facilities.Building.TennisFacility;
import org.junit.Before;
import org.junit.Test;

import static Factories.Facilities.TennisFactory.getTennisFacility;
import static org.junit.Assert.*;

public class TennisRepositoryImplTest {
    TennisRepositoryImpl tennis;
    @Before
    public void setUp() throws Exception {
        tennis = (TennisRepositoryImpl) TennisRepositoryImpl.getRepository();
    }
    @Test
    public void create() {
        TennisFacility x= getTennisFacility("TestName");
        tennis.create(x);
        assertNotNull(tennis.getAll());
        System.out.println(tennis.getAll());
    }

    @Test
    public void read() {
        TennisFacility x= getTennisFacility("TestName");
        tennis.create(x);
        assertNotNull(tennis.read("TestName"));
        System.out.println(tennis.getAll());
    }

    @Test
    public void update() {
        TennisFacility x= getTennisFacility("TestName");
        tennis.create(x);
        System.out.println(tennis.getAll());
        TennisFacility xUpdate=getTennisFacility("TestNameUpdated");
        tennis.update(xUpdate);
        assertEquals(xUpdate,tennis.read("TestID"));
        System.out.println(tennis.getAll());
    }

    @Test
    public void delete() {
        TennisFacility x= getTennisFacility("TestName");
        tennis.create(x);
        System.out.println(tennis.getAll());
        tennis.delete("TestName");
        System.out.println(tennis.getAll());
    }

}