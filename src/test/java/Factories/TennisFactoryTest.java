package Factories;

import Facilities.Building.TennisFacility;
import Factories.Facilities.TennisFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class TennisFactoryTest {

    @Test
    public void getTennisFacility() {
        TennisFacility tennis= TennisFactory.getTennisFacility("Tennis Course");
        System.out.println(tennis);
        assertNotNull(tennis);
    }
}