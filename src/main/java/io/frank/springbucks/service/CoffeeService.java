package io.frank.springbucks.service;

import io.frank.springbucks.model.Coffee;
import io.frank.springbucks.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author frank
 * @date 17/05/2019
 */
@Service
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public List<Coffee> findAll() {
        return coffeeRepository.findAll();
    }

    public Coffee save(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    public void delete(Coffee coffee) {
        coffeeRepository.delete(coffee);
    }
}
