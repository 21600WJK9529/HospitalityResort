package Database.Buildings;

import Database.Repository;
import Facilities.Building.TennisFacility;

import java.util.Set;

public interface TennisRepository extends Repository<TennisFacility,String> {
    Set<TennisFacility> getAll();
}
