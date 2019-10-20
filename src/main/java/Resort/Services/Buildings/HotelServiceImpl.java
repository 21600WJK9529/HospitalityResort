package Resort.Services.Buildings;

import Resort.Domain.Buildings.HotelRepository;
import Resort.Domain.Facilities.Building.HotelFacility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public class HotelServiceImpl implements HotelService{
    private HotelServiceImpl service=null;
    @Autowired
    private HotelRepository repository;

    private Set<HotelFacility> golfFacilities;
    private HotelServiceImpl(){

    }
    public HotelServiceImpl getService(){
        if (service == null) service= new HotelServiceImpl();
        return service;
    }

    public Set<HotelFacility> getAll() {
        return this.golfFacilities;
    }


    public HotelFacility create(HotelFacility golfFacilities) {
        return this.repository.save(golfFacilities);
    }


    public HotelFacility read(String id) {
        Optional<HotelFacility> optionalHotelFacility = repository.findById(id);
        return optionalHotelFacility.orElse(null);
    }


    public HotelFacility update(HotelFacility hotelFacility) {
        return repository.save(hotelFacility);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    private HotelFacility findBuilding(String id) {
        return this.golfFacilities.stream()
                .filter(hotelFacility -> hotelFacility.getHotelID().trim().equals(id))
                .findAny()
                .orElse(null);
    }
}

