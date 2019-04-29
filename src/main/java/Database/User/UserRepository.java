package Database.User;

import Database.Repository;
import Register.UserRegister;

import java.util.Set;

public interface UserRepository extends Repository<UserRegister,String> {
    Set<UserRegister> getAll();
}
