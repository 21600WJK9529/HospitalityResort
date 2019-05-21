package Resort.Controllers.Users;

import Resort.Domain.Register.MaintenanceRegister;
import Resort.Services.people.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    @Qualifier("MaintenanceServiceImpl")
    private MaintenanceService service;

    @PostMapping("/create")
    public MaintenanceRegister create(@RequestBody MaintenanceRegister maintenanceRegister){
        return service.create(maintenanceRegister);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public MaintenanceRegister read(@PathVariable String id) {
        return service.read(id);
    }
    @PostMapping("/update")
    @ResponseBody
    public MaintenanceRegister update(MaintenanceRegister maintenanceRegister){
        return service.update(maintenanceRegister);
    }
    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<MaintenanceRegister> getAll() {
        return service.getAll();
    }
}
