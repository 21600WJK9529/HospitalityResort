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
import java.util.ArrayList;
import java.util.List;
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
    public List<String> read(@PathVariable String id) {
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Read");
        MaintenanceRegister maintenanceRegister;
        maintenanceRegister = service.read(id);

        List<String> arr=new ArrayList<>();
        arr.add(maintenanceRegister.getId());
        arr.add(maintenanceRegister.getfName());
        arr.add(maintenanceRegister.getlName());
        arr.add(maintenanceRegister.getEmail());
        arr.add(maintenanceRegister.getFacility());
        arr.add(maintenanceRegister.getphoneNo());

        responseObj.setResponse(maintenanceRegister);
        return arr;
    }

    @PostMapping(value="/update/maintenanceRegister", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody MaintenanceRegister maintenanceRegister){
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Update");
        maintenanceRegister=service.update(maintenanceRegister);
        responseObj.setResponse(maintenanceRegister);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id){
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Delete");
        MaintenanceRegister maintenanceRegister = service.read(id);
        service.delete(maintenanceRegister.getId());
        responseObj.setResponse(maintenanceRegister);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<MaintenanceRegister> getAll() {
        return service.getAll();
    }
}
