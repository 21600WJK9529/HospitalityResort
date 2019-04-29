package Database.Buildings;

import Database.Repository;
import Facilities.Building.GolfFacility;

import java.util.Set;

public interface GolfRepository extends Repository<GolfFacility,String> {
    Set<GolfFacility> getAll();
}
