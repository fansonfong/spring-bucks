package io.frank.springbucks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.Collections;

/**
 * @author frank
 * @date 17/05/2019
 */
@Configuration
public class MongoDBConfig {
    @Bean
    public MongoCustomConversions mongoCustomConversions(MoneyReadConverter moneyReadConverter) {
        return new MongoCustomConversions(Collections.singletonList(moneyReadConverter));
    }
}
