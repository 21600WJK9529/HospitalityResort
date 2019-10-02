package Resort.Controllers.Users;

import Resort.Domain.Register.UserRegister;
import Resort.Domain.ResponseObj;
import Resort.Factories.Register.UserFactory;
import Resort.Factories.ResponseObjFactory;
import Resort.Services.people.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/HospitalityResort/user")
public class UserController {
    @Autowired
    private UserServiceImpl service;

    @PostMapping(value="/create/userRegister", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(){
        ResponseObj responseObj= ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Created");
        UserRegister userRegister1;
        UserRegister userRegister = UserFactory.getUserRegister("id", "fName", "lName", "phoneNo");
        userRegister1 = service.create(userRegister);
        responseObj.setResponse(userRegister1);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value ="/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity read(@PathVariable String id) {
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Read");
        UserRegister userRegister;
        userRegister = service.read(id);
        responseObj.setResponse(userRegister);
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping(value="/update/userRegister", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(){
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Update");
        UserRegister userRegister = service.read("id");
        service.update(userRegister);
        UserRegister userRegister1 = UserFactory.getUserRegister("newId","newFName", "newLName","newPhoneNo");
        userRegister = service.create(userRegister1);
        responseObj.setResponse(userRegister);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable String id){
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Delete");
        UserRegister userRegister = service.read("newId");
        service.delete(userRegister.getId());
        responseObj.setResponse(userRegister);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<UserRegister> getAll() {
        return service.getAll();
    }
}
