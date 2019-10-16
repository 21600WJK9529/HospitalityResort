package Resort.Services.people;

import Resort.Database.User.UserRepository;
import Resort.Domain.Register.User.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private UserServiceImpl service=null;
    @Autowired
    private UserRepository repository;

    private Set<UserRegister> userRegisters;
    private UserServiceImpl(){
    }
    public UserServiceImpl getService(){
        if (service == null) service= new UserServiceImpl();
        return service;
    }

    public Set<UserRegister> getAll() {
        return this.userRegisters;
    }


    public UserRegister create(UserRegister userRegister) {
        return this.repository.save(userRegister);
    }


    public UserRegister read(String id) {
        Optional<UserRegister> optionalReceptionRegister = repository.findById(id);
        return optionalReceptionRegister.orElse(null);
    }


    public UserRegister update(UserRegister userRegister) {
        return repository.save(userRegister);
    }

    public void delete(String id) {
       repository.deleteById(id);
    }

}

