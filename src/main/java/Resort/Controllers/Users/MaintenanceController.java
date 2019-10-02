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

    @PostMapping(value="/update/maintenanceRegister", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(){
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Update");
        MaintenanceRegister maintenanceRegister1 = MaintenanceFactory.getMaintenanceRegister("id","newFName", "newLName","newEmail","newFacility","newPhoneNo");
        service.update(maintenanceRegister1);
        responseObj.setResponse(maintenanceRegister1);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable String id){
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Delete");
        MaintenanceRegister maintenanceRegister = service.read("id");
        service.delete(maintenanceRegister.getId());
        responseObj.setResponse(maintenanceRegister);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping("/read/all")
    public ResponseEntity getAll() {
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Get all");
        Set<MaintenanceRegister> maintenanceRegisters = service.getAll();
        responseObj.setResponse(maintenanceRegisters);
        return ResponseEntity.ok(responseObj);
    }
}
