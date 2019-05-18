package io.frank.springbucks.repository;

import io.frank.springbucks.model.CoffeeOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author frank
 * @date 17/05/2019
 */
public interface CoffeeOrderRepository extends MongoRepository<CoffeeOrder, String> {
    List<CoffeeOrder> findByCustomer(String customer);
}
