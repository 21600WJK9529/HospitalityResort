package Resort.Domain.Buildings;

import Resort.Domain.Facilities.Building.GolfFacility;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("GolfRepository")
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

    public GolfFacility read(String golfID){
        return search(golfID);
    }

    public GolfFacility update(GolfFacility golfID){
        GolfFacility update=search(golfID.getId());
        if (golfFacilitySet.contains(update)){
            golfFacilitySet.remove(update);
            golfFacilitySet.add(golfID);
        }
        return golfID;
    }

    public void delete(String golfID){
        golfFacilitySet.remove(search(golfID));
    }

    public Set<GolfFacility> getAll(){
        return this.golfFacilitySet;
    }
    
    public GolfFacility search(String golfID){
        return golfFacilitySet.stream().filter(GolfFacility->
                GolfFacility.getId()==golfID)
                .findAny().orElse(null);

    }
}
