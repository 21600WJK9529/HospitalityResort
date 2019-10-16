package Resort.Domain.Register.User;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserRegister {
    @Id
    private String id;
    private String fName,lName,phoneNo;

        public UserRegister(){

        }

        private UserRegister(Builder builder) {
            this.id = builder.id;
            this.fName=builder.fName;
            this.lName=builder.lName;
            this.phoneNo=builder.phoneNo;
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
    public String getPhoneNo() {
        return phoneNo;
    }

        public static class Builder {
            private String id,fName,lName,phoneNo;

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

            public Builder setPhoneNo(String phoneNo) {
                this.phoneNo = phoneNo;
                return this;
            }

            public UserRegister build(){
                return  new UserRegister(this);
            }


        }
    @Override
    public String toString() {
        return "UserRegister{" +
                "id='" + id + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", phoneNo=" + phoneNo +
                '}';
    }
}
