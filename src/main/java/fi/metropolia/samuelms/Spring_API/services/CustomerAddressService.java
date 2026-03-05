package fi.metropolia.samuelms.Spring_API.services;

import fi.metropolia.samuelms.Spring_API.dto.CustomerAddressDto;
import fi.metropolia.samuelms.Spring_API.entities.CustomerAddress;
import fi.metropolia.samuelms.Spring_API.exceptions.ResourceNotFoundException;
import fi.metropolia.samuelms.Spring_API.repositories.CustomerAddressRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerAddressService {

    private CustomerAddressRepository customerAddressRepository;

    public CustomerAddressService(CustomerAddressRepository customerAddressRepository) {
        this.customerAddressRepository = customerAddressRepository;
    }

    public CustomerAddressDto getCustomerAddressById(int id) {
        CustomerAddress customerAddress = customerAddressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer address not found"));
        return mapToDto(customerAddress);
    }

    private CustomerAddressDto mapToDto(CustomerAddress customerAddress) {
        CustomerAddressDto dto = new CustomerAddressDto();
        dto.setId(customerAddress.getId());
        dto.setAddress(customerAddress.getStreetAddress());
        dto.setCity(customerAddress.getCity());
        dto.setPostalCode(customerAddress.getPostalCode());
        dto.setCountry(customerAddress.getCountry());
        dto.setCustomer(customerAddress.getCustomer());
        return dto;
    }


}
