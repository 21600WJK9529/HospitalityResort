package Resort.Domain.Maintenance;

import Resort.Domain.Register.Maintenance.MaintenanceRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<MaintenanceRegister,String> {
}
