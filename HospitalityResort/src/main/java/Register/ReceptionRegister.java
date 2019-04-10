package Register;

public class ReceptionRegister {
    private String id;
    private String fName;
    private String lName;
    private long phoneNo;
    private String email;
    private String facility;



    protected ReceptionRegister() {
    }

    public ReceptionRegister(ReceptionRegister.Builder builder) {
        this.id = builder.id;
        this.fName=builder.fName;
        this.lName=builder.lName;
        this.phoneNo=builder.phoneNo;
        this.email = builder.email;
    }

    public static class Builder {

        private String id;
        private String fName;
        private String lName;
        private long phoneNo;
        private String email;
        private String facility;

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

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setFacility(String facility) {
            this.facility = facility;
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

        public String getEmail() {
            return email;
        }
        public String getFacility() {
            return facility;
        }
    }
}
