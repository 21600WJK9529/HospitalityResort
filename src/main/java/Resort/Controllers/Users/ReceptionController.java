package Resort.Controllers.Users;

import Resort.Domain.Register.ReceptionRegister;
import Resort.Services.people.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/reception")
public class ReceptionController {

    @Autowired
    @Qualifier("ReceptionServiceImpl")
    private ReceptionService service;

    @PostMapping("/create")
    public ReceptionRegister create(@RequestBody ReceptionRegister receptionRegister){
        return service.create(receptionRegister);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public ReceptionRegister read(@PathVariable String id) {
        return service.read(id);
    }
    @PostMapping("/update")
    @ResponseBody
    public ReceptionRegister update(ReceptionRegister receptionRegister){
        return service.update(receptionRegister);
    }
    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<ReceptionRegister> getAll() {
        return service.getAll();
    }
}

