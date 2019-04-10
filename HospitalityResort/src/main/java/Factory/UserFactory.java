package Factory;

import Register.UserRegister;

public class UserFactory {
    public static UserRegister getUserRegister(String id,String fName,String lName,long phoneNo){
        return new UserRegister.Builder().setId(id)
                .setfName(fName)
                .setlName(lName)
                .setPhoneNo(phoneNo)
                .build();
    }
}
