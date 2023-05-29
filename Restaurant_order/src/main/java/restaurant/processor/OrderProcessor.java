package restaurant.processor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import restaurant.order.Order;
import restaurant.order.OrderRepository;
import restaurant.order.Status;

import java.util.List;

@Component
public class OrderProcessor {

    private final OrderRepository orderRepository;

    public OrderProcessor(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Scheduled(fixedDelay = 5000)
    public void processOrders() {
        List<Order> pendingOrders = orderRepository.findByStatus(Status.PENDING);

        for (Order order : pendingOrders) {
            order.setStatus(Status.IN_PROGRESS);
            orderRepository.save(order);
            try {
                Thread.sleep(2000); // Delay of 2 seconds
            } catch (InterruptedException e) {
                // log to console
            }

            order.setStatus(Status.COMPLETED);
            orderRepository.save(order);
        }
    }
}

