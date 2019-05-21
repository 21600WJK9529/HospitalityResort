package Resort.Services.Buildings;

import Resort.Domain.Facilities.Building.TennisFacility;
import Resort.Services.IService;

import java.util.Set;

public interface TennisService extends IService<TennisFacility,String> {
    Set<TennisFacility> getAll();
}
