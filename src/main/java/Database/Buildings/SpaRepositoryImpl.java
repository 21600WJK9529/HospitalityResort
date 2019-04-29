package Database.Buildings;

import Facilities.Building.SpaFacility;

import java.util.HashSet;
import java.util.Set;

public class SpaRepositoryImpl implements SpaRepository {
    private static SpaRepository repository = null;
    private Set<SpaFacility> spaFacilitySet;

    private SpaRepositoryImpl() {
        this.spaFacilitySet = new HashSet<>();
    }
    public static SpaRepository getRepository(){
        if(repository==null) repository=new SpaRepositoryImpl();
        return repository;
    }
    public SpaFacility create(SpaFacility spaFacility){
        this.spaFacilitySet.add(spaFacility);
        return spaFacility;
    }
    public SpaFacility read(String spaName){

        return search(spaName);
    }
    public SpaFacility update(SpaFacility spaName){
        SpaFacility update=search(spaName.getSpaName());
        if (spaFacilitySet.contains(update)){
            spaFacilitySet.remove(update);
            spaFacilitySet.add(spaName);
        }
        return spaName;
    }
    public void delete(String spaName){
        spaFacilitySet.remove(search(spaName));
    }
    public Set<SpaFacility> getAll(){
        return this.spaFacilitySet;
    }

    public SpaFacility search(String spaName){
        return spaFacilitySet.stream().filter(SpaFacility->
                SpaFacility.getSpaName()==spaName)
                .findAny().orElse(null);

    }
}
