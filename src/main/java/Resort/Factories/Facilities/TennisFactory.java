package Resort.Factories.Facilities;

import Resort.Domain.Facilities.Building.TennisFacility;

public class TennisFactory {
    public static TennisFacility getTennisFacility(String id,String name){
        return new TennisFacility.Builder().setTennisID(id)
                .setTennisName(name)
                .build();
    }
}
