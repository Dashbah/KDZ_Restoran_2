package restaurant.dish;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer quantity;
}