package Resort.Controllers.Users;

import Resort.Domain.Register.Reception.ReceptionRegister;
import Resort.Domain.ResponseObj;
import Resort.Factories.ResponseObjFactory;
import Resort.Services.people.ReceptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/HospitalityResort/reception")
public class ReceptionController {

    @Autowired
    private ReceptionServiceImpl service;

    @PostMapping("/create/reception")
    public ReceptionRegister create(@RequestBody ReceptionRegister receptionRegister){
        return service.create(receptionRegister);
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

    @PostMapping("/update/receptionRegister")
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

