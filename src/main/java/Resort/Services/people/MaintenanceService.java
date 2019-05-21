package Resort.Services.people;

import Resort.Domain.Register.MaintenanceRegister;
import Resort.Services.IService;

import java.util.Set;

public interface MaintenanceService extends IService <MaintenanceRegister,String> {
    Set<MaintenanceRegister> getAll();
}
