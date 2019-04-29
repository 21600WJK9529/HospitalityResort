package Database.Buildings;

import Database.Repository;
import Facilities.Building.RestaurantFacility;

import java.util.Set;

public interface RestaurantRepository extends Repository<RestaurantFacility,String> {
    Set<RestaurantFacility> getAll();
}
