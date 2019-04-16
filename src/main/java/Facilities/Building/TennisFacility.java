package Facilities.Building;

import Interfaces.FacilitiesInterface;

public class TennisFacility implements FacilitiesInterface {
    private String tennisName;

    private TennisFacility() {
    }
    private TennisFacility(Builder builder) {
        this.tennisName=builder.tennisName;
    }
    public String getTennisName() {
        return tennisName;
    }

    @Override
    public void println() {
        System.out.println("Tennis Facility");
    }

    public static class Builder {
        private String tennisName;

        public Builder setTennisName(String tennisName){
            this.tennisName=tennisName;
            return this;
        }
        public TennisFacility build(){
            return  new TennisFacility(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "tennisName='" + tennisName + '\'' +
                    '}';
        }
    }
}
