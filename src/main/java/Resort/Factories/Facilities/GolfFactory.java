package Resort.Factories.Facilities;

import Resort.Domain.Facilities.Building.GolfFacility;

public class GolfFactory {
    public static GolfFacility getGolfFacility(String golfID,String name){
        return new GolfFacility.Builder().setId(golfID)
                .setGolfName(name)
                .build();
    }
}
