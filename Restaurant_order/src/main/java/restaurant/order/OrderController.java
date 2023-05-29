package restaurant.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "restaurant/v2/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
        if (orderRequest == null) {
            return ResponseEntity.badRequest().build();
        }
        return orderService.createOrder(orderRequest);
    }

    @GetMapping
    public ResponseEntity<Order> findOrderById(@RequestParam int id) {
        return orderService.findOrderById(id);
    }
}
