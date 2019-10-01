package Resort.Controllers.Users;

import Resort.Domain.Register.Maintenance.MaintenanceRegister;
import Resort.Domain.ResponseObj;
import Resort.Factories.Register.MaintenanceFactory;
import Resort.Factories.ResponseObjFactory;
import Resort.Services.people.MaintenanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/HospitalityResort/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceServiceImpl service;

    @PostMapping(value="/create/maintenanceRegister", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(){
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Created");
        MaintenanceRegister maintenanceRegister1;
        MaintenanceRegister maintenanceRegister = MaintenanceFactory.getMaintenanceRegister("id", "fName", "lName", "email", "facility", "phoneNo");
        maintenanceRegister1 = service.create(maintenanceRegister);
        responseObj.setResponse(maintenanceRegister1);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value ="/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity read(@PathVariable String id) {
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Read");
        MaintenanceRegister maintenanceRegister;
        maintenanceRegister = service.read(id);
        responseObj.setResponse(maintenanceRegister);
        return ResponseEntity.ok(responseObj);
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
