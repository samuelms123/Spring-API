package fi.metropolia.samuelms.Spring_API.controllers;

import fi.metropolia.samuelms.Spring_API.dto.OrderDto;
import fi.metropolia.samuelms.Spring_API.entities.Order;
import fi.metropolia.samuelms.Spring_API.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController( OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Integer id) {
        OrderDto od = orderService.getOrderById(id);
        return ResponseEntity.ok(od);
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody Order order) {
        OrderDto od = orderService.createNewOrder(order);
        return ResponseEntity.ok(od);
    }
}
