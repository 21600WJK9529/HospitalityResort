package Resort.Domain.Buildings;

import Resort.Database.Repository;
import Resort.Domain.Facilities.Building.SpaFacility;

import java.util.Set;

public interface SpaRepository extends Repository<SpaFacility,String> {
    Set<SpaFacility> getAll();
}
