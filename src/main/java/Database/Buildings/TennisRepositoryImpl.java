package Database.Buildings;

import Facilities.Building.TennisFacility;

import java.util.HashSet;
import java.util.Set;

public class TennisRepositoryImpl implements TennisRepository {
    private static TennisRepository repository = null;
    private Set<TennisFacility> tennisFacilitySet;
    private TennisRepositoryImpl() {
        this.tennisFacilitySet = new HashSet<>();
    }

    public static TennisRepository getRepository(){
        if(repository==null) repository=new TennisRepositoryImpl();
        return repository;
    }
    public TennisFacility create(TennisFacility tennisFacility){
        this.tennisFacilitySet.add(tennisFacility);
        return tennisFacility;
    }
    public TennisFacility read(String tennisName){

        return search(tennisName);
    }
    public TennisFacility update(TennisFacility tennisName){
        TennisFacility update=search(tennisName.getTennisName());
        if (tennisFacilitySet.contains(update)){
            tennisFacilitySet.remove(update);
            tennisFacilitySet.add(tennisName);
        }
        return tennisName;
    }
    public void delete(String tennisName){
        tennisFacilitySet.remove(search(tennisName));
    }
    public Set<TennisFacility> getAll(){
        return this.tennisFacilitySet;
    }
    public TennisFacility search(String tennisName){
        return tennisFacilitySet.stream().filter(TennisFacility->
                TennisFacility.getTennisName()==tennisName)
                .findAny().orElse(null);

    }
}
