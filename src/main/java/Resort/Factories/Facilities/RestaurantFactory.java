package Resort.Factories.Facilities;

import Resort.Domain.Facilities.Building.RestaurantFacility;

public class RestaurantFactory {
    public static RestaurantFacility getRestaurantFacility(String id,String name){
        return new RestaurantFacility.Builder().setRestaurantID(id)
                .setRestaurantName(name)
                .build();
    }
}
