package Facilities.Building;

import Interfaces.FacilitiesInterface;

public class GolfFacility implements FacilitiesInterface {
    private String golfName;

    private GolfFacility() {
    }
    private GolfFacility(Builder builder) {
        this.golfName=builder.golfName;
    }
    public String getGolfName() {
        return golfName;
    }

    @Override
    public void println() {
        System.out.println("Golf Facility");
    }

    public static class Builder {
        private String golfName;

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
        return "Builder{" +
                "golfName='" + golfName + '\'' +
                '}';
    }
}
