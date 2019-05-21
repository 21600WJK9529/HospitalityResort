package Resort.Factories;

import Resort.Domain.Facilities.Building.GolfFacility;
import Resort.Factories.Facilities.GolfFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class GolfFactoryTest {

    @Test
    public void getGolfFacility() {
        GolfFacility golf= GolfFactory.getGolfFacility("GolfID","GolfName");
        System.out.println(golf);
        assertNotNull(golf);
    }
}