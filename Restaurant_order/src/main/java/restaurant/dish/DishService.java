package restaurant.dish;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<Dish> getMenu() {
        // todo: check if they are > 0
        return dishRepository.findAll();
    }
}