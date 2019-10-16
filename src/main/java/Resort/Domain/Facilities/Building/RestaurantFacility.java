//package Resort.Domain.Facilities.Building;
//
//
//import Resort.Domain.Facilities.FacilitiesInterface;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RestaurantFacility implements FacilitiesInterface {
//    private String restaurantID,restaurantName;
//
//    private RestaurantFacility() {
//    }
//    private RestaurantFacility(Builder builder) {
//        this.restaurantID=builder.restaurantID;
//        this.restaurantName=builder.restaurantName;
//    }
//    public String getRestaurantID(){return restaurantID;}
//    public String getRestaurantName() {
//        return restaurantName;
//    }
//
//    @Override
//    public void println() {
//        System.out.println("Restaurant");
//    }
//
//    public static class Builder {
//        private String restaurantID,restaurantName;
//
//        public Builder setRestaurantID(String restaurantID) {
//            this.restaurantID = restaurantID;
//            return this;
//        }
//
//        public Builder setRestaurantName(String restaurantName) {
//            this.restaurantName = restaurantName;
//            return this;
//        }
//
//        public RestaurantFacility build() {
//            return new RestaurantFacility(this);
//        }
//
//
//    }
//
//    @Override
//    public String toString() {
//        return "RestaurantFacility{" +
//                "restaurantID='" + restaurantID + '\'' +
//                ", restaurantName='" + restaurantName + '\'' +
//                '}';
//    }
//}
