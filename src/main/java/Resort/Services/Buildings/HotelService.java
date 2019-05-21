package Resort.Services.Buildings;

import Resort.Domain.Facilities.Building.HotelFacility;
import Resort.Services.IService;

import java.util.Set;

public interface HotelService extends IService<HotelFacility,String> {
    Set<HotelFacility> getAll();
}
