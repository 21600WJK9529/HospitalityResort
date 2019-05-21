package Resort.Factories.Facilities;

import Resort.Domain.Facilities.Building.GolfFacility;

public class GolfFactory {
    public static GolfFacility getGolfFacility(String name){
        return new GolfFacility.Builder().setGolfName(name)
                .build();
    }
}
