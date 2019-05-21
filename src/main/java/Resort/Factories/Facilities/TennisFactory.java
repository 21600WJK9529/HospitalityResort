package Resort.Factories.Facilities;

import Resort.Domain.Facilities.Building.TennisFacility;

public class TennisFactory {
    public static TennisFacility getTennisFacility(String name){
        return new TennisFacility.Builder().setTennisName(name)
                .build();
    }
}
