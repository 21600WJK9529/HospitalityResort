package Factories;

import Facilities.Building.SpaFacility;
import Factories.Facilities.SpaFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SpaFactoryTest {
    @Test
    public void getSpaFacility() {
        SpaFacility spa= SpaFactory.getSpaFacility("Spa");
        System.out.println(spa);
        assertNotNull(spa);
    }
}
