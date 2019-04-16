package Facilities.Building;

import Interfaces.FacilitiesInterface;

public class HotelFacility implements FacilitiesInterface {
    private String hotelName;

    private HotelFacility() {
    }
    private HotelFacility(Builder builder) {
        this.hotelName=builder.hotelName;
    }
    public String getHotelName() {
        return hotelName;
    }

    @Override
    public void println() {
        System.out.println("Hotel");
    }

    public static class Builder {
        private String hotelName;

        public Builder setHotelName(String hotelName){
            this.hotelName=hotelName;
            return this;
        }
        public HotelFacility build(){
            return  new HotelFacility(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "hotelName='" + hotelName + '\'' +
                    '}';
        }
    }
}
