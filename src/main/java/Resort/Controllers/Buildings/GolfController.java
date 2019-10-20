package Resort.Controllers.Buildings;

import Resort.Domain.Facilities.Building.GolfFacility;
import Resort.Domain.ResponseObj;
import Resort.Factories.ResponseObjFactory;
import Resort.Services.Buildings.GolfServiceImpl;
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
@RequestMapping(value ="/HospitalityResort/golf")
public class GolfController {

    @Autowired
    private GolfServiceImpl service;

    @PostMapping(value = "/create/golfCreate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@Valid @RequestBody GolfFacility golfFacility){

        return ResponseEntity.ok(service.create(golfFacility));
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public List<String> read(@PathVariable String id) {
        ResponseObj responseObj= ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Read");
        GolfFacility golfFacility;
        golfFacility = service.read(id);

        List<String> arr=new ArrayList<>();
        arr.add(golfFacility.getGolfID());
        arr.add(golfFacility.getGolfName());

        responseObj.setResponse(golfFacility);
        return arr;
    }
    @PostMapping(value="/update/golfFacility", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody GolfFacility golfFacility){
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Update");
        golfFacility=service.update(golfFacility);
        responseObj.setResponse(golfFacility);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value="/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable String id){
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Delete");
        GolfFacility golfFacility = service.read(id);
        service.delete(golfFacility.getGolfID());
        responseObj.setResponse(golfFacility);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping("/read/all")
    public Set<GolfFacility> getAll() {
        return service.getAll();
    }
}
