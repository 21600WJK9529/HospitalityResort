//package Resort.Services.Buildings;
//
//import Resort.Domain.Buildings.GolfRepository;
//import Resort.Domain.Buildings.GolfRepositoryImpl;
//import Resort.Domain.Facilities.Building.GolfFacility;
//import org.springframework.stereotype.Service;
//
//
//import java.util.Set;
//
//@Service ("GolfServiceImpl")
//public class GolfServiceImpl implements GolfService{
//    private GolfServiceImpl service=null;
//    private GolfRepository repository;
//
//    private Set<GolfFacility> golfFacilities;
//    public GolfServiceImpl(){
//        this.repository= GolfRepositoryImpl.getRepository();
//
//    }
//    public GolfServiceImpl getService(){
//        if (service == null) service= new GolfServiceImpl();
//        return service;
//    }
//
//    public Set<GolfFacility> getAll() {
//        return repository.getAll();
//    }
//
//
//    public GolfFacility create(GolfFacility golfFacilities) {
//        return this.repository.create(golfFacilities);
//    }
//
//
//    public GolfFacility read(String s) {
//        GolfFacility golfFacility = findBuilding(s);
//        return golfFacility;
//    }
//
//
//    public GolfFacility update(GolfFacility golfFacility) {
//        GolfFacility toDelete=findBuilding(golfFacility.getId());
//        if(toDelete!=null){
//            this.golfFacilities.remove(toDelete);
//            return create(golfFacility);
//        }
//        return null;
//    }
//
//    public void delete(String id) {
//        GolfFacility golfFacility=findBuilding(id);
//        if(golfFacility!=null)this.golfFacilities.remove(golfFacility);
//    }
//
//    private GolfFacility findBuilding(String id) {
//        return this.golfFacilities.stream()
//                .filter(golfFacility -> golfFacility.getId().trim().equals(id))
//                .findAny()
//                .orElse(null);
//    }
//}
//
//
