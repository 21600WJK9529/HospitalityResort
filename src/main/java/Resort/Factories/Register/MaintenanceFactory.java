package Resort.Factories.Register;

import Resort.Domain.Register.MaintenanceRegister;

public class MaintenanceFactory {
    public static MaintenanceRegister getMaintenanceRegister(String id, String fName, String lName, String email, String facility, String phoneNo){
        return new MaintenanceRegister.Builder().setId(id)
                .setfName(fName)
                .setlName(lName)
                .setPhoneNo(phoneNo)
                .setEmail(email)
                .setFacility(facility)
                .build();
    }
}
