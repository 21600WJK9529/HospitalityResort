package Resort.Services.people;

import Resort.Domain.Register.UserRegister;
import Resort.Services.IService;

import java.util.Set;

public interface UserService extends IService<UserRegister,String> {
    Set<UserRegister> getAll();
}
