package Factories;

import Facilities.Building.GolfFacility;
import Factories.Facilities.GolfFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class GolfFactoryTest {

    @Test
    public void getGolfFacility() {
        GolfFacility golf= GolfFactory.getGolfFacility("Golf Course");
        System.out.println(golf);
        assertNotNull(golf);
    }
}