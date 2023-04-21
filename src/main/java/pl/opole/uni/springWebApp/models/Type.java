package pl.opole.uni.springWebApp.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Type {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long Id;
  private String symbol;
  private String name;




    @ManyToOne
    @JoinColumn(name="id_type")
    private Producent producent;

    public Long getId() {
      return Id;
    }

    public void setId(Long id) {
      Id = id;
    }

    public String getSymbol() {
      return symbol;
    }

    public void setSymbol(String symbol) {
      this.symbol = symbol;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }


}
