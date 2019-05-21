package Resort.Services.people;

import Resort.Database.User.UserRepository;
import Resort.Database.User.UserRepositoryImpl;
import Resort.Domain.Register.UserRegister;

import java.util.Set;

public class UserServiceImpl {
    private UserServiceImpl service=null;
    private UserRepository repository;

    private Set<UserRegister> userRegisters;
    private UserServiceImpl(){
        this.repository= UserRepositoryImpl.getRepository();

    }
    public UserServiceImpl getService(){
        if (service == null) service= new UserServiceImpl();
        return service;
    }

    public Set<UserRegister> getAll() {
        return this.userRegisters;
    }


    public UserRegister create(UserRegister UserRegister) {
        return this.repository.create(UserRegister);
    }


    public UserRegister read(String s) {
        UserRegister userRegister = findStaff(s);
        return userRegister;
    }


    public UserRegister update(UserRegister userRegister) {
        UserRegister toDelete=findStaff(userRegister.getId());
        if(toDelete!=null){
            this.userRegisters.remove(toDelete);
            return create(userRegister);
        }
        return null;
    }

    public void delete(String id) {
        UserRegister userRegister=findStaff(id);
        if(userRegister!=null)this.userRegisters.remove(userRegister);
    }

    private UserRegister findStaff(String id) {
        return this.userRegisters.stream()
                .filter(userRegister -> userRegister.getId().trim().equals(id))
                .findAny()
                .orElse(null);
    }
}

