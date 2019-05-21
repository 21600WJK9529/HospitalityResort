package Resort.Services.Buildings;

import Resort.Domain.Buildings.RestaurantRepository;
import Resort.Domain.Buildings.RestaurantRepositoryImpl;
import Resort.Domain.Facilities.Building.RestaurantFacility;

import java.util.Set;

public class RestaurantServiceImpl {
    private RestaurantServiceImpl service=null;
    private RestaurantRepository repository;

    private Set<RestaurantFacility> restaurantFacilities;
    private RestaurantServiceImpl(){
        this.repository= RestaurantRepositoryImpl.getRepository();

    }
    public RestaurantServiceImpl getService(){
        if (service == null) service= new RestaurantServiceImpl();
        return service;
    }

    public Set<RestaurantFacility> getAll() {
        return this.restaurantFacilities;
    }


    public RestaurantFacility create(RestaurantFacility restaurantFacilities) {
        return this.repository.create(restaurantFacilities);
    }


    public RestaurantFacility read(String s) {
        RestaurantFacility restaurantFacility = findBuilding(s);
        return restaurantFacility;
    }


    public RestaurantFacility update(RestaurantFacility restaurantFacility) {
        RestaurantFacility toDelete=findBuilding(restaurantFacility.getRestaurantID());
        if(toDelete!=null){
            this.restaurantFacilities.remove(toDelete);
            return create(restaurantFacility);
        }
        return null;
    }

    public void delete(String id) {
        RestaurantFacility restaurantFacility=findBuilding(id);
        if(restaurantFacility!=null)this.restaurantFacilities.remove(restaurantFacility);
    }

    private RestaurantFacility findBuilding(String id) {
        return this.restaurantFacilities.stream()
                .filter(restaurantFacility -> restaurantFacility.getRestaurantID().trim().equals(id))
                .findAny()
                .orElse(null);
    }
}
