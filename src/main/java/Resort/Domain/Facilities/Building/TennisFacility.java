package Resort.Domain.Facilities.Building;

import Resort.Domain.Facilities.FacilitiesInterface;

public class TennisFacility implements FacilitiesInterface {
    private String tennisID,tennisName;

    private TennisFacility() {
    }
    private TennisFacility(Builder builder) {
        this.tennisID=builder.tennisID;
        this.tennisName=builder.tennisName;
    }
    public String getTennisID(){return tennisID;}
    public String getTennisName() {
        return tennisName;
    }

    @Override
    public void println() {
        System.out.println("Tennis Facility");
    }

    public static class Builder {
        private String tennisID,tennisName;

        public Builder setTennisID(String tennisID){
            this.tennisID=tennisID;
            return this;
        }

        public Builder setTennisName(String tennisName){
            this.tennisName=tennisName;
            return this;
        }
        public TennisFacility build(){
            return  new TennisFacility(this);
        }


    }

    @Override
    public String toString() {
        return "TennisFacility{" +
                "tennisID='" + tennisID + '\'' +
                ", tennisName='" + tennisName + '\'' +
                '}';
    }
}
