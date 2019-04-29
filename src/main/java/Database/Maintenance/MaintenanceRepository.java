package Database.Maintenance;

import Database.Repository;
import Register.MaintenanceRegister;

import java.util.Set;

public interface MaintenanceRepository extends Repository<MaintenanceRegister,String> {
    Set<MaintenanceRegister> getAll();
}
