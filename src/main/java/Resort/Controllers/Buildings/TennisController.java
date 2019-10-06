//package Resort.Controllers.Buildings;
//
//import Resort.Domain.Facilities.Building.TennisFacility;
//import Resort.Services.Buildings.TennisService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Set;
//
//@RestController
//@RequestMapping("/tennis")
//public class TennisController {
//
//    @Autowired
//    @Qualifier("TennisServiceImpl")
//    private TennisService service;
//
//    @PostMapping("/create")
//    public TennisFacility create(@RequestBody TennisFacility tennisFacility){
//        return service.create(tennisFacility);
//    }
//
//    @GetMapping("/read/{id}")
//    @ResponseBody
//    public TennisFacility read(@PathVariable String id) {
//        return service.read(id);
//    }
//    @PostMapping("/update")
//    @ResponseBody
//    public TennisFacility update(TennisFacility tennisFacility){
//        return service.update(tennisFacility);
//    }
//    @GetMapping("/delete/{id}")
//    @ResponseBody
//    public void delete(@PathVariable String id){
//        service.delete(id);
//    }
//
//    @GetMapping("/read/all")
//    @ResponseBody
//    public Set<TennisFacility> getAll() {
//        return service.getAll();
//    }
//}
