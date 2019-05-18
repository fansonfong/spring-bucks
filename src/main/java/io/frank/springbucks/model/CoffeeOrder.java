package io.frank.springbucks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Enumerated;
import java.util.Date;
import java.util.List;

/**
 * Created by frank on 17/05/2019
 */
@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeOrder {
    @Id
    private String id;
    private String customer;
    private List<Coffee> items;
    @Enumerated
    private OrderState state;

    private Date createTime;
    private Date updateTime;
}
