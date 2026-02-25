package fi.metropolia.samuelms.Spring_API.controllers;

import fi.metropolia.samuelms.Spring_API.entity.Customer;
import fi.metropolia.samuelms.Spring_API.entity.CustomerAddress;
import fi.metropolia.samuelms.Spring_API.repositories.CustomerAddressRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customeraddress")
public class CustomerAddressController {
    private final CustomerAddressRepository customerAddressRepository;

    public CustomerAddressController(CustomerAddressRepository customerAddressRepository) {
        this.customerAddressRepository = customerAddressRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerAddress> getCustomerById(@PathVariable Integer id) {
        return customerAddressRepository.findById(id)
                .map(address -> ResponseEntity.ok(address))
                .orElse(ResponseEntity.notFound().build());
    }
}
