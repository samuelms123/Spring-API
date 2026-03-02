package fi.metropolia.samuelms.Spring_API.services;

import fi.metropolia.samuelms.Spring_API.dto.OrderDto;
import fi.metropolia.samuelms.Spring_API.entities.Order;
import fi.metropolia.samuelms.Spring_API.exceptions.ResourceNotFoundException;
import fi.metropolia.samuelms.Spring_API.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDto getOrderById(Integer id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        return mapToDto(order);
    }

    private OrderDto mapToDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setOrderDate(order.getOrderDate());
        dto.setDeliveryDate(order.getDeliveryDate());
        dto.setStatus(order.getStatus());
        return dto;
    }

}
