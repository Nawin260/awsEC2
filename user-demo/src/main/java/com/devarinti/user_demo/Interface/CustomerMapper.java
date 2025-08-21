package com.devarinti.user_demo.Interface;


import com.devarinti.user_demo.Entity.Customer;
import com.devarinti.user_demo.DTO.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "password", ignore = true)
    CustomerDTO toDTO(Customer customer);

    Customer toEntity(CustomerDTO dto);

}
