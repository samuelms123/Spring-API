package fi.metropolia.samuelms.Spring_API.controllers;

import fi.metropolia.samuelms.Spring_API.dto.CustomerDto;
import fi.metropolia.samuelms.Spring_API.entities.Customer;
import fi.metropolia.samuelms.Spring_API.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getDetailedCustomerById(@PathVariable Integer id) {
        CustomerDto customerDto = customerService.getDetailedCustomerById(id);
        return ResponseEntity.ok(customerDto);
    }

    @PostMapping()
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody Customer customer) {
        CustomerDto customerDto = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(
            @PathVariable Integer id,
            @RequestBody CustomerDto customerDto) {

        CustomerDto updatedCustomer = customerService.updateCustomer(id, customerDto);
        return ResponseEntity.ok(updatedCustomer);
    }
    }
