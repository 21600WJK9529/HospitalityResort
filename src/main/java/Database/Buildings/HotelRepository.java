package Database.Buildings;

import Database.Repository;
import Facilities.Building.HotelFacility;

import java.util.Set;

public interface HotelRepository extends Repository<HotelFacility,String> {
    Set<HotelFacility> getAll();
}
