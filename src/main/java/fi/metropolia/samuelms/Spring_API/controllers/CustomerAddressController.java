package fi.metropolia.samuelms.Spring_API.controllers;

import fi.metropolia.samuelms.Spring_API.dto.CustomerAddressDto;
import fi.metropolia.samuelms.Spring_API.entities.CustomerAddress;
import fi.metropolia.samuelms.Spring_API.repositories.CustomerAddressRepository;
import fi.metropolia.samuelms.Spring_API.services.CustomerAddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customeraddress")
public class CustomerAddressController {
    private final CustomerAddressService customerAddressService;

    public CustomerAddressController(CustomerAddressService customerAddressService) {
        this.customerAddressService = customerAddressService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerAddressDto> getCustomerAddressById(@PathVariable Integer id) {
        CustomerAddressDto cad = customerAddressService.getCustomerAddressById(id);
        return ResponseEntity.ok(cad);
    }
}
