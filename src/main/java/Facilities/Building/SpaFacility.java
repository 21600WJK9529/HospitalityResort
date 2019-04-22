package Facilities.Building;

import Interfaces.FacilitiesInterface;

public class SpaFacility implements FacilitiesInterface {
    private String spaName;

    private SpaFacility() {
    }
    private SpaFacility(Builder builder) {
        this.spaName=builder.spaName;
    }
    public String getSpaName() {
        return spaName;
    }

    @Override
    public void println() {
        System.out.println("Spa");
    }

    public static class Builder {
        private String spaName;

        public Builder setSpaName(String spaName){
            this.spaName=spaName;
            return this;
        }
        public SpaFacility build(){
            return  new SpaFacility(this);
        }


    }
    @Override
    public String toString() {
        return "Builder{" +
                "spaName='" + spaName + '\'' +
                '}';
    }
}
