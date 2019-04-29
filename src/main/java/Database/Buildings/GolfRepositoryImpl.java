package Database.Buildings;

import Facilities.Building.GolfFacility;

import java.util.HashSet;
import java.util.Set;

public class GolfRepositoryImpl implements GolfRepository {
    private static GolfRepository repository = null;
    private Set<GolfFacility> golfFacilitySet;

    private GolfRepositoryImpl() {
        this.golfFacilitySet = new HashSet<>();
    }
    public static GolfRepository getRepository(){
        if(repository==null) repository=new GolfRepositoryImpl();
        return repository;
    }
    public GolfFacility create(GolfFacility golfFacility){
        this.golfFacilitySet.add(golfFacility);
        return golfFacility;
    }
    public GolfFacility read(String golfName){
        
        return search(golfName);
    }
    public GolfFacility update(GolfFacility golfName){
        GolfFacility update=search(golfName.getGolfName());
        if (golfFacilitySet.contains(update)){
            golfFacilitySet.remove(update);
            golfFacilitySet.add(golfName);
        }
        return golfName;
    }
    public void delete(String golfName){
        golfFacilitySet.remove(search(golfName));
    }
    public Set<GolfFacility> getAll(){
        return this.golfFacilitySet;
    }
    
    public GolfFacility search(String golfName){
        return golfFacilitySet.stream().filter(GolfFacility->
                GolfFacility.getGolfName()==golfName)
                .findAny().orElse(null);

    }
}
