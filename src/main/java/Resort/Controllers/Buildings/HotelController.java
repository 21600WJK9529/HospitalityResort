package Resort.Controllers.Buildings;

import Resort.Domain.Facilities.Building.HotelFacility;
import Resort.Domain.Register.Maintenance.MaintenanceRegister;
import Resort.Domain.ResponseObj;
import Resort.Factories.ResponseObjFactory;
import Resort.Services.Buildings.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value ="HospitalityResort/hotel")
public class HotelController {

    @Autowired
    private HotelServiceImpl service;

    @PostMapping(value="/create/hotelRegister", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@Valid @RequestBody HotelFacility hotelFacility){
        return ResponseEntity.ok(service.create(hotelFacility));
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public List<String> read(@PathVariable String id) {
        ResponseObj responseObj= ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Read");
        HotelFacility hotelFacility;
        hotelFacility = service.read(id);

        List<String> arr=new ArrayList<>();
        arr.add(hotelFacility.getHotelID());
        arr.add(hotelFacility.getHotelName());

        responseObj.setResponse(hotelFacility);
        return arr;
    }

    @PostMapping(value="/update/maintenanceRegister", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody HotelFacility hotelFacility){
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Update");
        hotelFacility=service.update(hotelFacility);
        responseObj.setResponse(hotelFacility);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id){
        ResponseObj responseObj=ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Delete");
        HotelFacility hotelFacility = service.read(id);
        service.delete(hotelFacility.getHotelID());
        responseObj.setResponse(hotelFacility);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<HotelFacility> getAll() {
        return service.getAll();
    }
}

