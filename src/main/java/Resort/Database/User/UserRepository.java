package Resort.Database.User;

import Resort.Database.Repository;
import Resort.Domain.Register.UserRegister;

import java.util.Set;

public interface UserRepository extends Repository<UserRegister,String> {
    Set<UserRegister> getAll();
}
