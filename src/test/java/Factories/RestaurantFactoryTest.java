package Factories;

import Facilities.Building.RestaurantFacility;
import Factories.Facilities.RestaurantFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantFactoryTest {

    @Test
    public void getRestaurantFacility() {
        RestaurantFacility restaurant= RestaurantFactory.getRestaurantFacility("Restaurant A");
        System.out.println(restaurant);
        assertNotNull(restaurant);
    }
}