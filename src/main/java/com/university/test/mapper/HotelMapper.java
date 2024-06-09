package com.university.test.mapper;

import com.university.test.dto.DetailedHotelDTO;
import com.university.test.dto.PostHotelDTO;
import com.university.test.dto.SimpleHotelDTO;
import com.university.test.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ContactsMapper.class, ArrivalTimeMapper.class, AddressMapper.class})
public interface HotelMapper {

    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    DetailedHotelDTO hotelToDetailedHotelDTO(Hotel hotel);

    SimpleHotelDTO hotelToSimpleHotelDTO(Hotel hotel);

    Hotel PostHotelDTOToHotel(PostHotelDTO postHotelDTO);

}
