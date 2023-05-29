package restaurant.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public ResponseEntity<Order> createOrder(OrderRequest orderRequest) {
        var newOrder = new Order();
        newOrder.setUserId(orderRequest.getUserId());
        newOrder.setSpecialRequests(orderRequest.getSpecialRequests());
        return ResponseEntity.ok(orderRepository.save(newOrder));
    }

    public ResponseEntity<Order> findOrderById(int id) {
        try {
            return ResponseEntity.ok(
                    orderRepository.findById((long) id).orElseThrow()
            );
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
