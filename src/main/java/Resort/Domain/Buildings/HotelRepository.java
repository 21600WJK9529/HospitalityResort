package Resort.Domain.Buildings;

import Resort.Database.Repository;
import Resort.Domain.Facilities.Building.HotelFacility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface HotelRepository extends JpaRepository<HotelFacility,String> {
}
