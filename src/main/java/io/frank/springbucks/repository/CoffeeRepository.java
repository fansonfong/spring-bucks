package io.frank.springbucks.repository;

import io.frank.springbucks.model.Coffee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author frank
 * @date 17/05/2019
 */
public interface CoffeeRepository extends MongoRepository<Coffee, String> {
    List<Coffee> findByName(String name);
}
