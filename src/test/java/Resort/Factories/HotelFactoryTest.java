package Resort.Factories;

import Resort.Domain.Facilities.Building.HotelFacility;
import Resort.Factories.Facilities.HotelFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class HotelFactoryTest {

    @Test
    public void getHotelFacility() {
        HotelFacility hotel= HotelFactory.getHotelFacility("Hotel A", "Hotel Name");
        System.out.println(hotel);
        assertNotNull(hotel);
    }
}