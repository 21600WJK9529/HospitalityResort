package Register;

import java.util.Set;

public class UserRegister {

    private String id;
    private String fName;
    private String lName;
    private long phoneNo;
    private Set<UserRegister> userRegister;


        public UserRegister(Builder builder) {
            this.id = builder.id;
            this.fName=builder.fName;
            this.lName=builder.lName;
            this.phoneNo=builder.phoneNo;
        }

        public static class Builder {

            private String id;
            private String fName;
            private String lName;
            private long phoneNo;
            private Set<UserRegister> userRegister;

            public Builder setId(String id) {
                this.id = id;
                return this;
            }
            public Builder setfName(String fName) {
                this.fName = fName;
                return this;
            }

            public Builder setlName(String lName) {
                this.lName = lName;
                return this;
            }

            public Builder setPhoneNo(long phoneNo) {
                this.phoneNo = phoneNo;
                return this;
            }


            public String getId() {
                return id;
            }

            public String getfName() {
                return fName;
            }

            public String getlName() {
                return lName;
            }

            public long getPhoneNo() {
                return phoneNo;
            }


            public UserRegister build(){
                return new UserRegister(this);
            }

            @Override
            public String toString() {
                return "Builder{" +
                        "id='" + id + '\'' +
                        ", fName='" + fName + '\'' +
                        ", lName='" + lName + '\'' +
                        ", phoneNo=" + phoneNo +
                        '}';
            }
        }
}
