package Factories.Register;

import Register.ReceptionRegister;

public class ReceptionFactory {
    public static ReceptionRegister getUserRegister(String id, String fName, String lName,String email, String facility, long phoneNo){
        return new ReceptionRegister.Builder().setId(id)
                .setfName(fName)
                .setlName(lName)
                .setPhoneNo(phoneNo)
                .setEmail(email)
                .setFacility(facility)
                .build();
    }
}
