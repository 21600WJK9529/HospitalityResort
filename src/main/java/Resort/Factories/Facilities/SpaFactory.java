package Resort.Factories.Facilities;

import Resort.Domain.Facilities.Building.SpaFacility;

public class SpaFactory {
    public static SpaFacility getSpaFacility(String id,String name){
        return new SpaFacility.Builder().setSpaID(id)
                .setSpaName(name)
                .build();
    }
}
