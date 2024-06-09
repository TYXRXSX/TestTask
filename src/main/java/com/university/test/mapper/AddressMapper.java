package com.university.test.mapper;

import com.university.test.dto.AddressDTO;
import com.university.test.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDTO toAddressDTO(Address address);

    Address fromAddressDTO(AddressDTO addressDTO);

}
