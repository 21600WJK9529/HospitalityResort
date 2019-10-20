package Resort.Domain.Facilities.Building;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HotelFacility {
    @Id
    private String hotelID;
    private String hotelName;

    private HotelFacility() {
    }

    public HotelFacility(String hotelID, String hotelName){
        this.hotelID=hotelID;
        this.hotelName=hotelName;
    }
    private HotelFacility(Builder builder) {
        this.hotelID=builder.hotelID;
        this.hotelName=builder.hotelName;
    }
    public String getHotelName() {
        return hotelName;
    }

    public String getHotelID() {
        return hotelID;
    }

    public static class Builder {
        private String hotelID,hotelName;

        public Builder setID(String hotelID){
            this.hotelID=hotelID;
            return this;
        }
        public Builder setHotelName(String hotelName){
            this.hotelName=hotelName;
            return this;
        }

        public HotelFacility build(){
            return  new HotelFacility(this);
        }


    }

    @Override
    public String toString() {
        return "HotelFacility{" +
                "hotelID='" + hotelID + '\'' +
                ", hotelName='" + hotelName + '\'' +
                '}';
    }
}
