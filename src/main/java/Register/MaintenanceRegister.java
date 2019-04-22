package Register;

public class MaintenanceRegister {
    private String id,fName,lName,email,facility;
    private long phoneNo;

    private MaintenanceRegister() {
    }

    private MaintenanceRegister(Builder builder) {
        this.id = builder.id;
        this.fName=builder.fName;
        this.lName=builder.lName;
        this.phoneNo=builder.phoneNo;
        this.facility=builder.facility;
        this.email = builder.email;
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

    public String getEmail() {
        return email;
    }
    public String getFacility() {
        return facility;
    }

    public static class Builder {

        private String id,fName,lName,email,facility;
        private long phoneNo;

        public Builder setId(String id){
            this.id=id;
            return this;
        }
        public Builder setfName(String fName){
            this.fName=fName;
            return this;
        }
        public Builder setlName(String lName){
            this.lName=lName;
            return this;
        }
        public Builder setPhoneNo(long phoneNo){
            this.phoneNo=phoneNo;
            return this;
        }
        public Builder setEmail(String email){
            this.email=email;
            return this;
        }
        public Builder setFacility(String facility){
            this.facility=facility;
            return this;
        }
        public MaintenanceRegister build(){
            return  new MaintenanceRegister(this);
        }

    }

    @Override
    public String toString() {
        return "Builder{" +
                "id='" + id + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", facility='" + facility + '\'' +
                ", phoneNo=" + phoneNo +
                '}';
    }
}
