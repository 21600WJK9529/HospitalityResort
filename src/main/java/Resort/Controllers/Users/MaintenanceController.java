package Resort.Controllers.Users;

import Resort.Domain.Register.MaintenanceRegister;
import Resort.Domain.ResponseObj;
import Resort.Factories.Register.MaintenanceFactory;
import Resort.Factories.ResponseObjFactory;
import Resort.Services.people.MaintenanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/HospitalityResort/lookup/maintenance", method = RequestMethod.POST)
public class MaintenanceController {

    @Autowired
    private MaintenanceServiceImpl service;

    @PostMapping(value="/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public MaintenanceRegister create(@PathVariable MaintenanceRegister maintenanceRegister){
        MaintenanceRegister createMaintenanceRegister;
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Maintenance created");
        createMaintenanceRegister = MaintenanceFactory.getMaintenanceRegister("id","fname", "lname","email","facility","phoneNo");
        createMaintenanceRegister = service.create(createMaintenanceRegister);
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
