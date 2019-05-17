package io.frank.springbucks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by frank on 17/05/2019
 */
@Entity
@Table(name = "T_ORDER")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeOrder extends BaseEntity {
    private String customer;
    @ManyToMany
    @JoinTable(name = "T_ORDER_COFFEE")
    @OrderBy("id")
    private List<Coffee> items;
    @Enumerated
    @Column(nullable = false)
    private OrderState state;
}
