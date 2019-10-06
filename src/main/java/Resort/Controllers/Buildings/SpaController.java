//package Resort.Controllers.Buildings;
//
//import Resort.Domain.Facilities.Building.SpaFacility;
//import Resort.Services.Buildings.SpaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Set;
//
//@RestController
//@RequestMapping("/spa")
//public class SpaController {
//
//    @Autowired
//    @Qualifier("SpaServiceImpl")
//    private SpaService service;
//
//    @PostMapping("/create")
//    public SpaFacility create(@RequestBody SpaFacility spaFacility){
//        return service.create(spaFacility);
//    }
//
//    @GetMapping("/read/{id}")
//    @ResponseBody
//    public SpaFacility read(@PathVariable String id) {
//        return service.read(id);
//    }
//    @PostMapping("/update")
//    @ResponseBody
//    public SpaFacility update(SpaFacility spaFacility){
//        return service.update(spaFacility);
//    }
//    @GetMapping("/delete/{id}")
//    @ResponseBody
//    public void delete(@PathVariable String id){
//        service.delete(id);
//    }
//
//    @GetMapping("/read/all")
//    @ResponseBody
//    public Set<SpaFacility> getAll() {
//        return service.getAll();
//    }
//}