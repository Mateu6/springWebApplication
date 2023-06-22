package pl.opole.uni.springWebApp.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders") // Zmieniona nazwa tabeli
public class Order<OrderItem> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private AppUser user;

  @OneToMany(targetEntity = Order.class)
  private List<OrderItem> orderItems;

  private String status;


  public Order() {
    super();
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public AppUser getUser() {
    return user;
  }

  public void setUser(AppUser appUser) {
    this.user = appUser;
  }

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}


