package fi.metropolia.samuelms.Spring_API.services;

import fi.metropolia.samuelms.Spring_API.dto.OrderDto;
import fi.metropolia.samuelms.Spring_API.entities.Customer;
import fi.metropolia.samuelms.Spring_API.entities.CustomerAddress;
import fi.metropolia.samuelms.Spring_API.entities.Order;
import fi.metropolia.samuelms.Spring_API.exceptions.ResourceNotFoundException;
import fi.metropolia.samuelms.Spring_API.repositories.CustomerAddressRepository;
import fi.metropolia.samuelms.Spring_API.repositories.CustomerRepository;
import fi.metropolia.samuelms.Spring_API.repositories.OrderRepository;
import fi.metropolia.samuelms.Spring_API.utils.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private CustomerAddressRepository customerAddressRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, CustomerAddressRepository customerAddressRepository) {

        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.customerAddressRepository = customerAddressRepository;
    }

    public OrderDto getOrderById(Integer id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        return OrderMapper.toDto(order);
    }

    public OrderDto createNewOrder(Order order) {
        Customer customer = customerRepository.findById(order.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        CustomerAddress address = customerAddressRepository
                .findById(order.getCustomerAddress().getId())
                .orElseThrow(() -> new RuntimeException("Address not found"));

        order.setCustomer(customer);
        order.setCustomerAddress(address);

        Order saved = orderRepository.save(order);

        return OrderMapper.toDto(saved);
    }

}
