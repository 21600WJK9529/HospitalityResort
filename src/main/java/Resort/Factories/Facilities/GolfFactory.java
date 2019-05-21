package Resort.Factories.Facilities;

import Resort.Domain.Facilities.Building.GolfFacility;

public class GolfFactory {
    public static GolfFacility getGolfFacility(String id,String name){
        return new GolfFacility.Builder().setId(id)
                .setGolfName(name)
                .build();
    }
}
