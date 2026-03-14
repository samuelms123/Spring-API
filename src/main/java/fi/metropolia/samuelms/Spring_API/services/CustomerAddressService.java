package fi.metropolia.samuelms.Spring_API.services;

import fi.metropolia.samuelms.Spring_API.dto.CustomerAddressDto;
import fi.metropolia.samuelms.Spring_API.entities.CustomerAddress;
import fi.metropolia.samuelms.Spring_API.exceptions.ResourceNotFoundException;
import fi.metropolia.samuelms.Spring_API.repositories.CustomerAddressRepository;
import fi.metropolia.samuelms.Spring_API.utils.CustomerAddressMapper;
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
        return CustomerAddressMapper.toDto(customerAddress);
    }

}
