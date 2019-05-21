package Resort.Domain.Buildings;

import Resort.Database.Repository;
import Resort.Domain.Facilities.Building.TennisFacility;

import java.util.Set;

public interface TennisRepository extends Repository<TennisFacility,String> {
    Set<TennisFacility> getAll();
}
