package restaurant.order;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "order_dish")
@Data
public class OrderDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "dish_id")
    private Integer dishId;

    @Column
    private Integer quantity;

    @Column
    private BigDecimal price;
}