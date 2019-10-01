package Resort.Domain.Maintenance;

import Resort.Database.Repository;
import Resort.Domain.Register.Maintenance.MaintenanceRegister;

import java.util.Set;

public interface MaintenanceRepository extends Repository<MaintenanceRegister,String> {
    Set<MaintenanceRegister> getAll();
}
