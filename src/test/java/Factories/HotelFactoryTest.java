package Factories;

import Facilities.Building.HotelFacility;
import Factories.Facilities.HotelFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class HotelFactoryTest {

    @Test
    public void getHotelFacility() {
        HotelFacility hotel= HotelFactory.getHotelFacility("Hotel A");
        System.out.println(hotel);
        assertNotNull(hotel);
    }
}