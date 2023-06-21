package pl.opole.uni.springWebApp.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.opole.uni.springWebApp.models.Order;
import pl.opole.uni.springWebApp.repositories.OrderRepository;

import java.util.List;

@ResponseStatus(HttpStatus.NOT_FOUND)
class OrderNotFoundException extends RuntimeException {
  public OrderNotFoundException(String message) {
    super(message);
  }
}

@Service
@Transactional
public class OrderService {
  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public Order createOrder(Order order) {
    // logika walidacji i przetwarzania danych

    // zapisanie zamówienia
    return orderRepository.save(order);
  }

  public Order updateOrder(Long orderId, Order order) {
    // logika walidacji i przetwarzania danych

    // aktualizacja zamówienia
    return orderRepository.save(order);
  }

  public void deleteOrder(Long orderId) {
    // usuwanie zamówienia
    orderRepository.deleteById(orderId);
  }

  public Order getOrderById(Long orderId) {
    // pobieranie zamówienia po ID
    return orderRepository.findById(orderId)
      .orElseThrow(() -> new OrderNotFoundException("Order not found"));
  }

  public List<Order> getAllOrders() {
    // pobieranie wszystkich zamówień
    return orderRepository.findAll();
  }
}

