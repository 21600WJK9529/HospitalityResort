package Resort.Domain.Facilities.Building;


import Resort.Domain.Facilities.FacilitiesInterface;

public class SpaFacility implements FacilitiesInterface {
    private String spaID,spaName;

    private SpaFacility() {
    }
    private SpaFacility(Builder builder) {
        this.spaID=builder.spaID;
        this.spaName=builder.spaName;
    }
    public String getSpaID(){return  spaID;}
    public String getSpaName() {
        return spaName;
    }

    @Override
    public void println() {
        System.out.println("Spa");
    }

    public static class Builder {
        private String spaID,spaName;

        public Builder setSpaID(String spaID){
            this.spaID=spaID;
            return this;
        }
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
