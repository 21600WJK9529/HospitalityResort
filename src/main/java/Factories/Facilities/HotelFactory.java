package Factories.Facilities;

import Facilities.Building.HotelFacility;

public class HotelFactory {
    public static HotelFacility getHotelFacility(String name){
        return new HotelFacility.Builder().setHotelName(name)
                .build();
    }
}
