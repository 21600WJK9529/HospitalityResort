//package Resort.Controllers.Buildings;
//import Resort.Domain.Facilities.Building.GolfFacility;
//import Resort.Services.Buildings.GolfService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Set;
//
//@RestController
//@RequestMapping("/golf")
//public class GolfController {
//
//    @Autowired
//    @Qualifier("GolfServiceImpl")
//    private GolfService service;
//
//    @PostMapping("/create")
//    public GolfFacility create(@RequestBody GolfFacility golfFacility){
//        return service.create(golfFacility);
//    }
//
//    @GetMapping("/read/{id}")
//    @ResponseBody
//    public GolfFacility read(@PathVariable String id) {
//        return service.read(id);
//    }
//    @PostMapping("/update")
//    @ResponseBody
//    public GolfFacility update(GolfFacility golfFacility){
//        return service.update(golfFacility);
//    }
//    @GetMapping("/delete/{id}")
//    @ResponseBody
//    public void delete(@PathVariable String id){
//        service.delete(id);
//    }
//
//    @GetMapping("/read/all")
//    @ResponseBody
//    public Set<GolfFacility> getAll() {
//        return service.getAll();
//    }
//}
