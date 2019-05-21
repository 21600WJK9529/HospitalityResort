package Resort.Factories.Facilities;

import Resort.Domain.Facilities.Building.SpaFacility;

public class SpaFactory {
    public static SpaFacility getSpaFacility(String name){
        return new SpaFacility.Builder().setSpaName(name)
                .build();
    }
}
