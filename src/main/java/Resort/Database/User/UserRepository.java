package Resort.Database.User;

import Resort.Domain.Register.User.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRegister,String> {
}
