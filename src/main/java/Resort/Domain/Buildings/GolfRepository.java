package Resort.Domain.Buildings;

import Resort.Domain.Facilities.Building.GolfFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GolfRepository extends JpaRepository<GolfFacility,String> {
}
