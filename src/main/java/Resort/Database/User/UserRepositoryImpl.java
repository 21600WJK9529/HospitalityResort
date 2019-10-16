//package Resort.Database.User;
//
//import Resort.Domain.Register.User.UserRegister;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class UserRepositoryImpl implements UserRepository{
//    private static UserRepository repository = null;
//    private Set<UserRegister> userRegisterSet;
//
//    private UserRepositoryImpl() {
//        this.userRegisterSet = new HashSet<>();
//    }
//
//    public static UserRepository getRepository(){
//        if(repository==null) repository=new UserRepositoryImpl();
//        return repository;
//    }
//
//    public UserRegister create(UserRegister user){
//        this.userRegisterSet.add(user);
//        return user;
//    }
//    public UserRegister read(String userID){
//        return search(userID);
//    }
//
//    public UserRegister update(UserRegister userRegister){
//        UserRegister update=search(userRegister.getId());
//        if (userRegisterSet.contains(update)){
//            userRegisterSet.remove(update);
//            userRegisterSet.add(userRegister);
//        }
//        return userRegister;
//    }
//    public void delete(String userID){
//        userRegisterSet.remove(search(userID));
//    }
//
//    public Set<UserRegister> getAll(){
//        return userRegisterSet;
//    }
//
//    public UserRegister search(String userID){
//        return userRegisterSet.stream().filter(UserRegister->
//                UserRegister.getId()==userID)
//                .findAny().orElse(null);
//
//    }
//
//}
