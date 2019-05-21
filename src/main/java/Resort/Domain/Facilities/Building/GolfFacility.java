package Resort.Domain.Facilities.Building;


import Resort.Domain.Facilities.FacilitiesInterface;

public class GolfFacility implements FacilitiesInterface {
    private String golfID,golfName;

    private GolfFacility() {
    }
    private GolfFacility(Builder builder) {
        this.golfID = builder.golfID;
        this.golfName=builder.golfName;
    }
    public String getGolfName() {
        return golfName;
    }
    public String getId() {
        return golfID;
    }
    @Override
    public void println() {
        System.out.println("Golf Facility");
    }


    public static class Builder {
        private String golfID,golfName;

        public Builder setId(String golfID){
            this.golfID=golfID;
            return this;
        }
        public Builder setGolfName(String golfName){
            this.golfName=golfName;
            return this;
        }

        public GolfFacility build(){
            return  new GolfFacility(this);
        }


    }

    @Override
    public String toString() {
        return "GolfFacility{" +
                "golfID='" + golfID + '\'' +
                ", golfName='" + golfName + '\'' +
                '}';
    }
}
