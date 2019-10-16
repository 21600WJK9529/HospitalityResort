//package Resort.Domain.Facilities.Building;
//
//
//import Resort.Domain.Facilities.FacilitiesInterface;
//
//public class HotelFacility implements FacilitiesInterface {
//    private String hotelID,hotelName;
//
//    private HotelFacility() {
//    }
//
//    private HotelFacility(Builder builder) {
//        this.hotelID=builder.hotelID;
//        this.hotelName=builder.hotelName;
//    }
//    public String getHotelName() {
//        return hotelName;
//    }
//    @Override
//    public void println() {
//        System.out.println("Hotel");
//    }
//
//    public String getHotelID() {
//        return hotelID;
//    }
//
//    public static class Builder {
//        private String hotelID,hotelName;
//
//        public Builder setID(String hotelID){
//            this.hotelID=hotelID;
//            return this;
//        }
//        public Builder setHotelName(String hotelName){
//            this.hotelName=hotelName;
//            return this;
//        }
//
//        public HotelFacility build(){
//            return  new HotelFacility(this);
//        }
//
//
//    }
//
//    @Override
//    public String toString() {
//        return "HotelFacility{" +
//                "hotelID='" + hotelID + '\'' +
//                ", hotelName='" + hotelName + '\'' +
//                '}';
//    }
//}
