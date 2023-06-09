package pl.opole.uni.springWebApp.models;
import javax.persistence.*;

@Entity
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Product product;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private AppUser user;

  private String comment;

  private int rating;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public AppUser getUser() {
    return user;
  }

  public void setUser(AppUser appUser) {
    this.user = appUser;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }
}

