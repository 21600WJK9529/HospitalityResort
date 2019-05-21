package Resort.Controllers.Buildings;

import Resort.Domain.Facilities.Building.RestaurantFacility;
import Resort.Services.Buildings.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    @Qualifier("RestaurantServiceImpl")
    private RestaurantService service;

    @PostMapping("/create")
    public RestaurantFacility create(@RequestBody RestaurantFacility restaurantFacility){
        return service.create(restaurantFacility);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public RestaurantFacility read(@PathVariable String id) {
        return service.read(id);
    }
    @PostMapping("/update")
    @ResponseBody
    public RestaurantFacility update(RestaurantFacility restaurantFacility){
        return service.update(restaurantFacility);
    }
    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<RestaurantFacility> getAll() {
        return service.getAll();
    }
}
