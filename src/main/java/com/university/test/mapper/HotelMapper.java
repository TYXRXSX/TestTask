package com.university.test.mapper;

import com.university.test.dto.DetailedHotelDTO;
import com.university.test.dto.PostHotelDTO;
import com.university.test.dto.SimpleHotelDTO;
import com.university.test.entity.Address;
import com.university.test.entity.Contacts;
import com.university.test.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ContactsMapper.class, ArrivalTimeMapper.class, AddressMapper.class})
public abstract class HotelMapper {


    public abstract DetailedHotelDTO hotelToDetailedHotelDTO(Hotel hotel);


    @Mapping(target = "address", expression = "java(mapAddress(hotel.getAddress()))")
    @Mapping(target = "phone", expression = "java(mapPhone(hotel.getContacts()))")
    public abstract SimpleHotelDTO hotelToSimpleHotelDTO(Hotel hotel);

    public abstract  Hotel PostHotelDTOToHotel(PostHotelDTO postHotelDTO);

    String mapAddress(Address address){
        return address.getHouseNumber() + " " + address.getStreet() + ", " + address.getCity() + ", " + address.getPostCode() + ", " + address.getCounty();
    }

    String mapPhone(Contacts contacts){
        return contacts.getPhone();
    }

}
