package fi.metropolia.samuelms.Spring_API.services;

import fi.metropolia.samuelms.Spring_API.dto.CustomerDto;
import fi.metropolia.samuelms.Spring_API.entities.Customer;
import fi.metropolia.samuelms.Spring_API.exceptions.ResourceNotFoundException;
import fi.metropolia.samuelms.Spring_API.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDto getDetailedCustomerById(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        return mapToDto(customer);
    }

    public CustomerDto createCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return mapToDto(savedCustomer);
    }

    public CustomerDto updateCustomer(Integer id, CustomerDto dto) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (dto.getFirstName() != null) {
            customer.setFirstName(dto.getFirstName());
        }

        if (dto.getLastName() != null) {
            customer.setLastName(dto.getLastName());
        }

        if (dto.getEmail() != null) {
            customer.setEmail(dto.getEmail());
        }

        if (dto.getPhone() != null) {
            customer.setPhone(dto.getPhone());
        }

        Customer savedCustomer = customerRepository.save(customer);

        return mapToDto(savedCustomer);
    }

    public void deleteCustomer(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        customerRepository.deleteById(customer.getId());
    }

    private CustomerDto mapToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customer.getEmail());
        return customerDto;
    }
}
