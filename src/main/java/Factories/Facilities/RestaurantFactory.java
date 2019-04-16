package Factories.Facilities;

import Facilities.Building.RestaurantFacility;

public class RestaurantFactory {
    public static RestaurantFacility getRestaurantFacility(String name){
        return new RestaurantFacility.Builder().setRestaurantName(name)
                .build();
    }
}
