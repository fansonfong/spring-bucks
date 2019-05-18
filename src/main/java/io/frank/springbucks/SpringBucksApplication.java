package io.frank.springbucks;

import io.frank.springbucks.config.MoneyReadConverter;
import io.frank.springbucks.model.Coffee;
import io.frank.springbucks.model.CoffeeOrder;
import io.frank.springbucks.repository.CoffeeOrderRepository;
import io.frank.springbucks.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Slf4j
@EnableMongoRepositories
@SpringBootApplication
public class SpringBucksApplication implements CommandLineRunner {
	@Autowired
	private CoffeeRepository coffeeRepository;

	@Autowired
	private CoffeeOrderRepository coffeeOrderRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBucksApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Coffee espresso = Coffee.builder()
				.name("espresso")
				.price(Money.of(CurrencyUnit.of("CNY"), 20.0))
				.createTime(new Date())
				.updateTime(new Date()).build();
		Coffee latte = Coffee.builder()
				.name("latte")
				.price(Money.of(CurrencyUnit.of("CNY"), 30.0))
				.createTime(new Date())
				.updateTime(new Date()).build();

		coffeeRepository.save(espresso);
		coffeeRepository.save(latte);

		Coffee coffee = coffeeRepository.findByName("espresso").get(0);

		CoffeeOrder coffeeOrder = CoffeeOrder.builder()
				.items(new ArrayList<>(Arrays.asList(espresso, latte)))
				.customer("Frank")
				.createTime(new Date())
				.updateTime(new Date())
				.build();

		coffeeOrderRepository.save(coffeeOrder);

		CoffeeOrder co = coffeeOrderRepository.findByCustomer("Frank").get(0);


		coffeeOrderRepository.delete(coffeeOrder);
		coffeeRepository.delete(espresso);
		coffeeRepository.delete(latte);
	}
}
