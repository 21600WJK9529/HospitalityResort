package Resort.Domain.Buildings;

import Resort.Domain.Facilities.Building.RestaurantFacility;
import org.junit.Before;
import org.junit.Test;

import static Resort.Factories.Facilities.RestaurantFactory.getRestaurantFacility;
import static org.junit.Assert.*;

public class RestaurantRepositoryImplTest {
    RestaurantRepositoryImpl restaurant;
    @Before
    public void setUp() throws Exception {
        restaurant = (RestaurantRepositoryImpl) RestaurantRepositoryImpl.getRepository();
    }
    @Test
    public void create() {
        RestaurantFacility x= getRestaurantFacility("TestName");
        restaurant.create(x);
        assertNotNull(restaurant.getAll());
        System.out.println(restaurant.getAll());
    }

    @Test
    public void read() {
        RestaurantFacility x= getRestaurantFacility("TestName");
        restaurant.create(x);
        assertNotNull(restaurant.read("TestName"));
        System.out.println(restaurant.getAll());
    }

    @Test
    public void update() {
        RestaurantFacility x= getRestaurantFacility("TestName");
        restaurant.create(x);
        System.out.println(restaurant.getAll());
        RestaurantFacility xUpdate=getRestaurantFacility("TestNameUpdated");
        restaurant.update(xUpdate);
        assertEquals(xUpdate,restaurant.read("TestID"));
        System.out.println(restaurant.getAll());
    }

    @Test
    public void delete() {
        RestaurantFacility x= getRestaurantFacility("TestName");
        restaurant.create(x);
        System.out.println(restaurant.getAll());
        restaurant.delete("TestName");
        System.out.println(restaurant.getAll());
    }

}