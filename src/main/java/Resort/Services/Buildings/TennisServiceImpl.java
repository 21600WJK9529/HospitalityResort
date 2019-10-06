//package Resort.Services.Buildings;
//
//import Resort.Domain.Buildings.TennisRepository;
//import Resort.Domain.Buildings.TennisRepositoryImpl;
//import Resort.Domain.Facilities.Building.TennisFacility;
//import org.springframework.stereotype.Service;
//
//import java.util.Set;
//@Service("TennisServiceImpl")
//public class TennisServiceImpl implements TennisService{
//    private TennisServiceImpl service=null;
//    private TennisRepository repository;
//
//    private Set<TennisFacility> tennisFacilities;
//    private TennisServiceImpl(){
//        this.repository= TennisRepositoryImpl.getRepository();
//
//    }
//    public TennisServiceImpl getService(){
//        if (service == null) service= new TennisServiceImpl();
//        return service;
//    }
//
//    public Set<TennisFacility> getAll() {
//        return this.tennisFacilities;
//    }
//
//
//    public TennisFacility create(TennisFacility tennisFacilities) {
//        return this.repository.create(tennisFacilities);
//    }
//
//
//    public TennisFacility read(String s) {
//        TennisFacility tennisFacility = findBuilding(s);
//        return tennisFacility;
//    }
//
//
//    public TennisFacility update(TennisFacility tennisFacility) {
//        TennisFacility toDelete=findBuilding(tennisFacility.getTennisID());
//        if(toDelete!=null){
//            this.tennisFacilities.remove(toDelete);
//            return create(tennisFacility);
//        }
//        return null;
//    }
//
//    public void delete(String id) {
//        TennisFacility tennisFacility=findBuilding(id);
//        if(tennisFacility!=null)this.tennisFacilities.remove(tennisFacility);
//    }
//
//    private TennisFacility findBuilding(String id) {
//        return this.tennisFacilities.stream()
//                .filter(tennisFacility -> tennisFacility.getTennisID().trim().equals(id))
//                .findAny()
//                .orElse(null);
//    }
//}
