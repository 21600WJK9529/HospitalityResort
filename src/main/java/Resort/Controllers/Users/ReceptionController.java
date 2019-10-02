package Resort.Controllers.Users;

import Resort.Domain.Register.ReceptionRegister;
import Resort.Domain.ResponseObj;
import Resort.Factories.Register.ReceptionFactory;
import Resort.Factories.ResponseObjFactory;
import Resort.Services.people.ReceptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/HospitalityResort/reception")
public class ReceptionController {

    @Autowired
    private ReceptionServiceImpl service;

    @PostMapping(value="/create/receptionRegister", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(){
        ResponseObj responseObj= ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Created");
        ReceptionRegister receptionRegister1;
        ReceptionRegister receptionRegister = ReceptionFactory.getReceptionRegister("id", "fName", "lName", "email", "facility", "phoneNo");
        receptionRegister1 = service.create(receptionRegister);
        responseObj.setResponse(receptionRegister1);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value ="/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity read(@PathVariable String id) {
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Read");
        ReceptionRegister receptionRegister;
        receptionRegister = service.read(id);
        responseObj.setResponse(receptionRegister);
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping(value="/update/receptionRegister", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(){
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Update");
        ReceptionRegister receptionRegister = service.read("id");
        service.update(receptionRegister);
        ReceptionRegister receptionRegister1 = ReceptionFactory.getReceptionRegister("newId","newFName", "newLName","newEmail","newFacility","newPhoneNo");
        receptionRegister = service.create(receptionRegister1);
        responseObj.setResponse(receptionRegister);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable String id){
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Delete");
        ReceptionRegister receptionRegister = service.read("newId");
        service.delete(receptionRegister.getId());
        responseObj.setResponse(receptionRegister);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<ReceptionRegister> getAll() {
        return service.getAll();
    }
}

