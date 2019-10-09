package Resort.Controllers.Users;

import Resort.Domain.Register.Maintenance.MaintenanceRegister;
import Resort.Domain.ResponseObj;
import Resort.Factories.ResponseObjFactory;
import Resort.Services.people.MaintenanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/HospitalityResort/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceServiceImpl service;

    @PostMapping(value="/create/maintenanceRegister", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@Valid @RequestBody MaintenanceRegister maintenanceRegister){
        return ResponseEntity.ok(service.create(maintenanceRegister));
    }

    @GetMapping(value ="/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity read(@PathVariable String id) {
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Read");
        MaintenanceRegister maintenanceRegister;
        maintenanceRegister = service.read(id);
        responseObj.setResponse(maintenanceRegister);
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping(value="/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@RequestBody MaintenanceRegister maintenanceRegister, @PathVariable String id){
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Update");
        MaintenanceRegister find = service.read(id);
        service.update(find);
        responseObj.setResponse(maintenanceRegister);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable String id){
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Delete");
        MaintenanceRegister maintenanceRegister = service.read("newId");
        service.delete(maintenanceRegister.getId());
        responseObj.setResponse(maintenanceRegister);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<MaintenanceRegister> getAll() {
        return service.getAll();
    }
}
