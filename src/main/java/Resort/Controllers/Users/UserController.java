//package Resort.Controllers.Users;
//
//import Resort.Domain.Register.UserRegister;
//import Resort.Services.people.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Set;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    @Autowired
//    @Qualifier("UserServiceImpl")
//    private UserService service;
//
//    @PostMapping("/create")
//    public UserRegister create(@RequestBody UserRegister userRegister){
//        return service.create(userRegister);
//    }
//
//    @GetMapping("/read/{id}")
//    @ResponseBody
//    public UserRegister read(@PathVariable String id) {
//        return service.read(id);
//    }
//    @PostMapping("/update")
//    @ResponseBody
//    public UserRegister update(UserRegister userRegister){
//        return service.update(userRegister);
//    }
//    @GetMapping("/delete/{id}")
//    @ResponseBody
//    public void delete(@PathVariable String id){
//        service.delete(id);
//    }
//
//    @GetMapping("/read/all")
//    @ResponseBody
//    public Set<UserRegister> getAll() {
//        return service.getAll();
//    }
//}
