package Resort.Domain.Facilities.Building;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class GolfFacility {

    @Id
    private String golfID;

    private String golfName;

    private GolfFacility(){

    }
    public GolfFacility(Builder builder) {
        this.golfID = builder.golfID;
        this.golfName=builder.golfName;
    }

    public String getGolfID() {
        return golfID;
    }

    public String getGolfName() {
        return golfName;
    }


    public static class Builder {
        private String golfID,golfName;

        public Builder setId(String golfID){
            this.golfID=golfID;
            return this;
        }
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
        return "GolfFacility{" +
                "golfID='" + golfID + '\'' +
                ", golfName='" + golfName + '\'' +
                '}';
    }
}
