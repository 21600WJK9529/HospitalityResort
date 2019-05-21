package Resort.Services.Buildings;

import Resort.Domain.Facilities.Building.GolfFacility;
import Resort.Services.IService;

import java.util.Set;

public interface GolfService extends IService<GolfFacility,String> {
    Set<GolfFacility> getAll();
}
