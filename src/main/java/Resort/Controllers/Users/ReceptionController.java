package Resort.Controllers.Users;

import Resort.Domain.Register.Reception.ReceptionRegister;
import Resort.Domain.ResponseObj;
import Resort.Factories.ResponseObjFactory;
import Resort.Services.people.ReceptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/HospitalityResort/reception")
public class ReceptionController {

    @Autowired
    private ReceptionServiceImpl service;

    @PostMapping(value="/create/receptionRegister", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@Valid @RequestBody ReceptionRegister receptionRegister){
        return ResponseEntity.ok(service.create(receptionRegister));
    }

    @GetMapping(value ="/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> read(@PathVariable String id) {
        ResponseObj responseObj= ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Read");
        ReceptionRegister receptionRegister;
        receptionRegister = service.read(id);

        List<String> arr=new ArrayList<>();
        arr.add(receptionRegister.getId());
        arr.add(receptionRegister.getfName());
        arr.add(receptionRegister.getlName());
        arr.add(receptionRegister.getEmail());
        arr.add(receptionRegister.getFacility());
        arr.add(receptionRegister.getPhoneNo());

        responseObj.setResponse(receptionRegister);
        return arr;
    }

    @PostMapping(value="/update/receptionRegister", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody ReceptionRegister receptionRegister){
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Update");
        receptionRegister = service.update(receptionRegister);
        responseObj.setResponse(receptionRegister);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id){
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Delete");
        ReceptionRegister receptionRegister=service.read(id);
        service.delete(receptionRegister.getId());
        responseObj.setResponse(receptionRegister);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<ReceptionRegister> getAll() {
        return service.getAll();
    }
}

