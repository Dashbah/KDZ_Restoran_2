package restaurant.dish;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurant/v2/dishes")
public class DishController {
    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/menu")
    public ResponseEntity<List<Dish>> getMenu() {
        List<Dish> menu = dishService.getMenu();
        return ResponseEntity.ok(menu);
    }
}
