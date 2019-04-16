package Facilities.Building;

import Interfaces.FacilitiesInterface;

public class RestaurantFacility implements FacilitiesInterface {
    private String restaurantName;

    private RestaurantFacility() {
    }
    private RestaurantFacility(Builder builder) {
        this.restaurantName=builder.restaurantName;
    }
    public String getRestaurantName() {
        return restaurantName;
    }

    @Override
    public void println() {
        System.out.println("Restaurant");
    }

    public static class Builder {
        private String restaurantName;

        public Builder setRestaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
            return this;
        }

        public RestaurantFacility build() {
            return new RestaurantFacility(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "restaurantName='" + restaurantName + '\'' +
                    '}';
        }
    }
}
