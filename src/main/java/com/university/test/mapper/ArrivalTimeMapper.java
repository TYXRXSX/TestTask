package com.university.test.mapper;

import com.university.test.dto.ContactsDTO;
import com.university.test.entity.Contacts;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArrivalTimeMapper {

    ContactsMapper INSTANCE = Mappers.getMapper(ContactsMapper.class);

    ContactsDTO contactsDTOtoContacts(Contacts contacts);

    Contacts contactstoContactsDTO(ContactsDTO contactsDTO);

}
