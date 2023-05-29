package restaurant.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "order")
@Data
public class Order {
    @Id
    @GeneratedValue
    private Integer id;

    @JsonProperty("user_id")
    private Integer userId;

    @Enumerated
    private Status status;

    @JsonProperty("special_requests")
    private String specialRequests;

    @JsonProperty("created_at")
    private Timestamp createdAt;

    @JsonProperty("updated_at")
    private Timestamp updatedAt;

    @OneToMany
    private List<OrderDish> orderDishes;
}
