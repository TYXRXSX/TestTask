package com.university.test.mapper;

import com.university.test.dto.ArrivalTimeDTO;
import com.university.test.dto.ContactsDTO;
import com.university.test.entity.ArrivalTime;
import com.university.test.entity.Contacts;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArrivalTimeMapper {

    ArrivalTimeMapper INSTANCE = Mappers.getMapper(ArrivalTimeMapper.class);

    ArrivalTime arrivalTimeDTOToArrivalTime(ArrivalTimeDTO arrivalTimeDTO);

    ArrivalTimeDTO arrivalTimeToArrivalTimeDTO(ArrivalTime arrivalTime);
}
