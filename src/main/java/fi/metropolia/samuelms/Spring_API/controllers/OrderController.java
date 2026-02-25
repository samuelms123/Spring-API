package fi.metropolia.samuelms.Spring_API.controllers;

import fi.metropolia.samuelms.Spring_API.entity.Order;
import fi.metropolia.samuelms.Spring_API.repositories.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController( OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> getCustomerById(@PathVariable Integer id) {
        return orderRepository.findById(id)
                .map(order -> ResponseEntity.ok(order))
                .orElse(ResponseEntity.notFound().build());
    }
}
