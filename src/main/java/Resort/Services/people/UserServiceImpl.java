package Resort.Services.people;

import Resort.Database.User.UserRepository;
import Resort.Database.User.UserRepositoryImpl;
import Resort.Domain.Register.UserRegister;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    private UserServiceImpl service=null;
    private UserRepository repository;

    private Set<UserRegister> userRegisters;
    private UserServiceImpl(){
        repository= UserRepositoryImpl.getRepository();

    }
    public UserServiceImpl getService(){
        if (service == null) service= new UserServiceImpl();
        return service;
    }

    public Set<UserRegister> getAll() {
        return this.userRegisters;
    }


    public UserRegister create(UserRegister userRegister) {
        return this.repository.create(userRegister);
    }


    public UserRegister read(String id) {
        return repository.read(id);
    }


    public UserRegister update(UserRegister userRegister) {
        UserRegister toDelete=repository.read(userRegister.getId());
        if(toDelete!=null){
            this.repository.delete(toDelete.getId());
        }
        return repository.create(userRegister);
    }

    public void delete(String id) {
        UserRegister userRegister=repository.read(id);
        if(userRegister!=null) {
            repository.delete(userRegister.getId());
        }
    }
}

