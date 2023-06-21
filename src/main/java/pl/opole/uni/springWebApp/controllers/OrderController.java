package pl.opole.uni.springWebApp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.opole.uni.springWebApp.models.Order;
import pl.opole.uni.springWebApp.services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping
  public ResponseEntity<Order> createOrder(@RequestBody Order order) {
    Order createdOrder = orderService.createOrder(order);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
  }

  @PutMapping("/{orderId}")
  public ResponseEntity<Order> updateOrder(@PathVariable Long orderId, @RequestBody Order order) {
    Order updatedOrder = orderService.updateOrder(orderId, order);
    return ResponseEntity.ok(updatedOrder);
  }

  @DeleteMapping("/{orderId}")
  public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
    orderService.deleteOrder(orderId);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{orderId}")
  public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
    Order order = orderService.getOrderById(orderId);
    return ResponseEntity.ok(order);
  }

  @GetMapping
  public ResponseEntity<Object> getAllOrders() {
    List<Order> orders = orderService.getAllOrders();
    return ResponseEntity.ok(orders);
  }
}

