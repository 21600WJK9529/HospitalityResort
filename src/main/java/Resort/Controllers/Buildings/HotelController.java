//package Resort.Controllers.Buildings;
//
//import Resort.Domain.Facilities.Building.HotelFacility;
//import Resort.Services.Buildings.HotelService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Set;
//
//@RestController
//@RequestMapping("/hotel")
//public class HotelController {
//
//    @Autowired
//    @Qualifier("HotelServiceImpl")
//    private HotelService service;
//
//    @PostMapping("/create")
//    public HotelFacility create(@RequestBody HotelFacility hotelFacility){
//        return service.create(hotelFacility);
//    }
//
//    @GetMapping("/read/{id}")
//    @ResponseBody
//    public HotelFacility read(@PathVariable String id) {
//        return service.read(id);
//    }
//    @PostMapping("/update")
//    @ResponseBody
//    public HotelFacility update(HotelFacility hotelFacility){
//        return service.update(hotelFacility);
//    }
//    @GetMapping("/delete/{id}")
//    @ResponseBody
//    public void delete(@PathVariable String id){
//        service.delete(id);
//    }
//
//    @GetMapping("/read/all")
//    @ResponseBody
//    public Set<HotelFacility> getAll() {
//        return service.getAll();
//    }
//}
//
