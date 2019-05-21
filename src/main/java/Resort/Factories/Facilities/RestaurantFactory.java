package Resort.Factories.Facilities;

import Resort.Domain.Facilities.Building.RestaurantFacility;

public class RestaurantFactory {
    public static RestaurantFacility getRestaurantFacility(String name){
        return new RestaurantFacility.Builder().setRestaurantName(name)
                .build();
    }
}
