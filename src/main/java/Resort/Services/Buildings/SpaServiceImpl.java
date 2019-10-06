//package Resort.Services.Buildings;
//
//import Resort.Domain.Buildings.SpaRepository;
//import Resort.Domain.Buildings.SpaRepositoryImpl;
//import Resort.Domain.Facilities.Building.SpaFacility;
//import org.springframework.stereotype.Service;
//
//import java.util.Set;
//@Service("SpaServiceImpl")
//public class SpaServiceImpl implements SpaService{
//    private SpaServiceImpl service=null;
//    private SpaRepository repository;
//
//    private Set<SpaFacility> spaFacilities;
//    private SpaServiceImpl(){
//        this.repository= SpaRepositoryImpl.getRepository();
//
//    }
//    public SpaServiceImpl getService(){
//        if (service == null) service= new SpaServiceImpl();
//        return service;
//    }
//
//    public Set<SpaFacility> getAll() {
//        return this.spaFacilities;
//    }
//
//
//    public SpaFacility create(SpaFacility spaFacilities) {
//        return this.repository.create(spaFacilities);
//    }
//
//
//    public SpaFacility read(String s) {
//        SpaFacility spaFacility = findBuilding(s);
//        return spaFacility;
//    }
//
//
//    public SpaFacility update(SpaFacility spaFacility) {
//        SpaFacility toDelete=findBuilding(spaFacility.getSpaID());
//        if(toDelete!=null){
//            this.spaFacilities.remove(toDelete);
//            return create(spaFacility);
//        }
//        return null;
//    }
//
//    public void delete(String id) {
//        SpaFacility spaFacility=findBuilding(id);
//        if(spaFacility!=null)this.spaFacilities.remove(spaFacility);
//    }
//
//    private SpaFacility findBuilding(String id) {
//        return this.spaFacilities.stream()
//                .filter(spaFacility -> spaFacility.getSpaID().trim().equals(id))
//                .findAny()
//                .orElse(null);
//    }
//}
