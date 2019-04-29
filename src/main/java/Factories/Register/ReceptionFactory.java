package Factories.Register;

import Register.ReceptionRegister;

public class ReceptionFactory {
    public static ReceptionRegister getReceptionRegister(String id, String fName, String lName,String email, String facility, String phoneNo){
        return new ReceptionRegister.Builder().setId(id)
                .setfName(fName)
                .setlName(lName)
                .setPhoneNo(phoneNo)
                .setEmail(email)
                .setFacility(facility)
                .build();
    }
}
