package Resort.Factories.Register;

import Resort.Domain.Register.UserRegister;

public class UserFactory {
    public static UserRegister getUserRegister(String id,String fName,String lName,String phoneNo){
        return new UserRegister.Builder().setId(id)
                .setfName(fName)
                .setlName(lName)
                .setPhoneNo(phoneNo)
                .build();
    }

}
