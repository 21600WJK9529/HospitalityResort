package Factories.Register;

import Register.MaintenanceRegister;

public class MaintenanceFactory {
    public static MaintenanceRegister getUserRegister(String id, String fName, String lName, String email, String facility, long phoneNo){
        return new MaintenanceRegister.Builder().setId(id)
                .setfName(fName)
                .setlName(lName)
                .setPhoneNo(phoneNo)
                .setEmail(email)
                .setFacility(facility)
                .build();
    }
}
