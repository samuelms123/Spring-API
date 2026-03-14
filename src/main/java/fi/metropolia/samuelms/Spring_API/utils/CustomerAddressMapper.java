package fi.metropolia.samuelms.Spring_API.utils;

import fi.metropolia.samuelms.Spring_API.dto.CustomerAddressDto;
import fi.metropolia.samuelms.Spring_API.entities.CustomerAddress;

public class CustomerAddressMapper {

    private CustomerAddressMapper() {
    }

    public static CustomerAddressDto toDto(CustomerAddress customerAddress) {
        if (customerAddress == null) {
            return null;
        }

        CustomerAddressDto dto = new CustomerAddressDto();
        dto.setId(customerAddress.getId());
        dto.setAddress(customerAddress.getStreetAddress());
        dto.setCity(customerAddress.getCity());
        dto.setPostalCode(customerAddress.getPostalCode());
        dto.setCountry(customerAddress.getCountry());
        return dto;
    }
}