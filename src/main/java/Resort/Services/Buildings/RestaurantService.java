package Resort.Services.Buildings;

import Resort.Domain.Facilities.Building.RestaurantFacility;
import Resort.Services.IService;

import java.util.Set;

public interface RestaurantService extends IService<RestaurantFacility,String> {
    Set<RestaurantFacility> getAll();
}
