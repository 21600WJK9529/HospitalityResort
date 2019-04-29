package Database.Buildings;

import Database.Repository;
import Facilities.Building.SpaFacility;

import java.util.Set;

public interface SpaRepository extends Repository<SpaFacility,String> {
    Set<SpaFacility> getAll();
}
