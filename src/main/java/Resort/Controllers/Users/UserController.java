package Resort.Controllers.Users;

import Resort.Domain.Register.User.UserRegister;
import Resort.Domain.ResponseObj;
import Resort.Factories.ResponseObjFactory;
import Resort.Services.people.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/HospitalityResort/user")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @PostMapping("/create/user")
    public UserRegister create(@RequestBody UserRegister userRegister){
        return service.create(userRegister);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public List<String> read(@PathVariable String id) {
        ResponseObj responseObj= ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Read");
        UserRegister userRegister;
        userRegister = service.read(id);

        List<String> arr=new ArrayList<>();
        arr.add(userRegister.getId());
        arr.add(userRegister.getfName());
        arr.add(userRegister.getlName());
        arr.add(userRegister.getPhoneNo());

        responseObj.setResponse(userRegister);
        return arr;
    }
    @PostMapping("/update/userRegister")
    @ResponseBody
    public UserRegister update(UserRegister userRegister){
        return service.update(userRegister);
    }
    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<UserRegister> getAll() {
        return service.getAll();
    }
}
