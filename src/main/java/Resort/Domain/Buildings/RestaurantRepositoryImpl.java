package Resort.Domain.Buildings;

import Resort.Domain.Facilities.Building.RestaurantFacility;

import java.util.HashSet;
import java.util.Set;

public class RestaurantRepositoryImpl implements RestaurantRepository {
    private static RestaurantRepository repository = null;
    private Set<RestaurantFacility> restaurantFacilitySet;

    private RestaurantRepositoryImpl() {
        this.restaurantFacilitySet = new HashSet<>();
    }
    public static RestaurantRepository getRepository(){
        if(repository==null) repository=new RestaurantRepositoryImpl();
        return repository;
    }
    public RestaurantFacility create(RestaurantFacility restaurantFacility){
        this.restaurantFacilitySet.add(restaurantFacility);
        return restaurantFacility;
    }
    public RestaurantFacility read(String restaurantName){

        return search(restaurantName);
    }
    public RestaurantFacility update(RestaurantFacility restaurantName){
        RestaurantFacility update=search(restaurantName.getRestaurantName());
        if (restaurantFacilitySet.contains(update)){
            restaurantFacilitySet.remove(update);
            restaurantFacilitySet.add(restaurantName);
        }
        return restaurantName;
    }
    public void delete(String restaurantName){
        restaurantFacilitySet.remove(search(restaurantName));
    }
    public Set<RestaurantFacility> getAll(){
        return this.restaurantFacilitySet;
    }

    public RestaurantFacility search(String restaurantName){
        return restaurantFacilitySet.stream().filter(RestaurantFacility->
                RestaurantFacility.getRestaurantName()==restaurantName)
                .findAny().orElse(null);

    }
}
