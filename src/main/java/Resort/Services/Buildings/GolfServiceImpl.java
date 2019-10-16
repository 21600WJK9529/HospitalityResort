package Resort.Services.Buildings;

import Resort.Domain.Buildings.GolfRepository;
import Resort.Domain.Facilities.Building.GolfFacility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class GolfServiceImpl implements GolfService{
    private GolfServiceImpl service=null;
    @Autowired
    private GolfRepository repository;

    private Set<GolfFacility> golfFacilities;
    private GolfServiceImpl(){
    }

    public GolfServiceImpl getService(){
        if (service == null) service= new GolfServiceImpl();
        return service;
    }

    public Set<GolfFacility> getAll() {
        return this.golfFacilities;
    }


    public GolfFacility create(GolfFacility golfFacilities) {
        return this.repository.save(golfFacilities);
    }


    public GolfFacility read(String id) {
        Optional<GolfFacility> optionalGolfFacility = repository.findById(id);
        return optionalGolfFacility.orElse(null);
    }


    public GolfFacility update(GolfFacility golfFacility) {
       return repository.save(golfFacility);
    }

    public void delete(String id) {
       repository.deleteById(id);
    }

}


