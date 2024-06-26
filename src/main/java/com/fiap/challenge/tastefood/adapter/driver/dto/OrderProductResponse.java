package com.fiap.challenge.tastefood.adapter.driver.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderProductResponse {

    private Integer quantity;
    private BigDecimal price;
    private ProductResponse product;

}
