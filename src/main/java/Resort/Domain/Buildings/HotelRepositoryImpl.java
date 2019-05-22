package Resort.Domain.Buildings;

import Resort.Domain.Facilities.Building.HotelFacility;

import java.util.HashSet;
import java.util.Set;

public class HotelRepositoryImpl implements HotelRepository{
        private static HotelRepository repository = null;
        private Set<HotelFacility> hotelFacilitySet;

        private HotelRepositoryImpl() {
            this.hotelFacilitySet = new HashSet<>();
        }
        public static HotelRepository getRepository(){
            if(repository==null) repository=new HotelRepositoryImpl();
            return repository;
        }
        public HotelFacility create(HotelFacility hotelFacility){
            this.hotelFacilitySet.add(hotelFacility);
            return hotelFacility;
        }
        public HotelFacility read(String hotelName){

            return search(hotelName);
        }
        public HotelFacility update(HotelFacility hotelName){
            HotelFacility update=search(hotelName.getHotelName());
            if (hotelFacilitySet.contains(update)){
                hotelFacilitySet.remove(update);
                hotelFacilitySet.add(hotelName);
            }
            return hotelName;
        }
        public void delete(String hotelID){
            hotelFacilitySet.remove(search(hotelID));
        }
        public Set<HotelFacility> getAll(){
            return this.hotelFacilitySet;
        }

        public HotelFacility search(String hotelID){
            return hotelFacilitySet.stream().filter(HotelFacility->
                    HotelFacility.getHotelName()==hotelID)
                    .findAny().orElse(null);

        }
    }
