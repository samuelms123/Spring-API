package fi.metropolia.samuelms.Spring_API.controllers;

import fi.metropolia.samuelms.Spring_API.dto.OrderHistoryViewDto;
import fi.metropolia.samuelms.Spring_API.dto.OrderDto;
import fi.metropolia.samuelms.Spring_API.entities.Order;
import fi.metropolia.samuelms.Spring_API.services.OrderHistoryViewService;
import fi.metropolia.samuelms.Spring_API.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderHistoryViewService orderHistoryViewService;

    public OrderController(OrderService orderService, OrderHistoryViewService orderHistoryViewService) {
        this.orderService = orderService;
        this.orderHistoryViewService = orderHistoryViewService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Integer id) {
        OrderDto od = orderService.getOrderById(id);
        return ResponseEntity.ok(od);
    }

    @GetMapping("/history/{customerId}")
    public ResponseEntity<List<OrderHistoryViewDto>> getOrderHistoryByCustomerId(@PathVariable Integer customerId) {
        List<OrderHistoryViewDto> history = orderHistoryViewService.getOrderHistoryByCustomerId(customerId);
        return ResponseEntity.ok(history);
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody Order order) {
        OrderDto od = orderService.createNewOrder(order);
        return ResponseEntity.ok(od);
    }
}
