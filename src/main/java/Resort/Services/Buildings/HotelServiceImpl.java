package Resort.Services.Buildings;

import Resort.Domain.Buildings.HotelRepository;
import Resort.Domain.Buildings.HotelRepositoryImpl;
import Resort.Domain.Facilities.Building.HotelFacility;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("HotelServiceImpl")
public class HotelServiceImpl implements HotelService{
    private HotelServiceImpl service=null;
    private HotelRepository repository;

    private Set<HotelFacility> golfFacilities;
    private HotelServiceImpl(){
        this.repository= HotelRepositoryImpl.getRepository();

    }
    public HotelServiceImpl getService(){
        if (service == null) service= new HotelServiceImpl();
        return service;
    }

    public Set<HotelFacility> getAll() {
        return this.golfFacilities;
    }


    public HotelFacility create(HotelFacility golfFacilities) {
        return this.repository.create(golfFacilities);
    }


    public HotelFacility read(String s) {
        HotelFacility hotelFacility = findBuilding(s);
        return hotelFacility;
    }


    public HotelFacility update(HotelFacility hotelFacility) {
        HotelFacility toDelete=findBuilding(hotelFacility.getHotelID());
        if(toDelete!=null){
            this.golfFacilities.remove(toDelete);
            return create(hotelFacility);
        }
        return null;
    }

    public void delete(String id) {
        HotelFacility hotelFacility=findBuilding(id);
        if(hotelFacility!=null)this.golfFacilities.remove(hotelFacility);
    }

    private HotelFacility findBuilding(String id) {
        return this.golfFacilities.stream()
                .filter(hotelFacility -> hotelFacility.getHotelID().trim().equals(id))
                .findAny()
                .orElse(null);
    }
}

