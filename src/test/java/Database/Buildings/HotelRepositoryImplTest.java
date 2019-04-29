package Database.Buildings;

import Facilities.Building.HotelFacility;
import org.junit.Before;
import org.junit.Test;

import static Factories.Facilities.HotelFactory.getHotelFacility;
import static org.junit.Assert.*;

public class HotelRepositoryImplTest {
    HotelRepositoryImpl hotel;
    @Before
    public void setUp() throws Exception {
        hotel = (HotelRepositoryImpl) HotelRepositoryImpl.getRepository();
    }
    @Test
    public void create() {
        HotelFacility x= getHotelFacility("TestName");
        hotel.create(x);
        assertNotNull(hotel.getAll());
        System.out.println(hotel.getAll());
    }

    @Test
    public void read() {
        HotelFacility x= getHotelFacility("TestName");
        hotel.create(x);
        assertNotNull(hotel.read("TestName"));
        System.out.println(hotel.getAll());
    }

    @Test
    public void update() {
        HotelFacility x= getHotelFacility("TestName");
        hotel.create(x);
        System.out.println(hotel.getAll());
        HotelFacility xUpdate=getHotelFacility("TestNameUpdated");
        hotel.update(xUpdate);
        assertEquals(xUpdate,hotel.read("TestID"));
        System.out.println(hotel.getAll());
    }

    @Test
    public void delete() {
        HotelFacility x= getHotelFacility("TestName");
        hotel.create(x);
        System.out.println(hotel.getAll());
        hotel.delete("TestName");
        System.out.println(hotel.getAll());
    }

}