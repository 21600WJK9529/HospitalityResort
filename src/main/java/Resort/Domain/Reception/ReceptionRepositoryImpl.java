//package Resort.Domain.Reception;
//
//import Resort.Domain.Register.Reception.ReceptionRegister;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class ReceptionRepositoryImpl implements ReceptionRepository {
//    private static ReceptionRepository repository = null;
//    private Set<ReceptionRegister> receptionRegisterSet;
//
//    private ReceptionRepositoryImpl() {
//        this.receptionRegisterSet = new HashSet<>();
//    }
//    public static ReceptionRepository getRepository(){
//        if(repository==null) repository=new ReceptionRepositoryImpl();
//        return repository;
//    }
//    public ReceptionRegister create(ReceptionRegister reception){
//        this.receptionRegisterSet.add(reception);
//        return reception;
//    }
//    public ReceptionRegister read(String receptionID){
//        return search(receptionID);
//    }
//
//    public ReceptionRegister update(ReceptionRegister receptionRegister){
//        ReceptionRegister update=search(receptionRegister.getId());
//        if (receptionRegisterSet.contains(update)){
//            receptionRegisterSet.remove(update);
//            receptionRegisterSet.add(receptionRegister);
//        }
//        return receptionRegister;
//    }
//    public void delete(String receptionID){
//        receptionRegisterSet.remove(search(receptionID));
//    }
//    public Set<ReceptionRegister> getAll(){
//        return this.receptionRegisterSet;
//    }
//    public ReceptionRegister search(String receptionID){
//        return receptionRegisterSet.stream().filter(ReceptionRegister->
//                ReceptionRegister.getId()==receptionID)
//                .findAny().orElse(null);
//
//    }
//
//}
