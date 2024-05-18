package com.fiap.challenge.tastefood.core.application.dto;

import com.fiap.challenge.tastefood.core.domain.entity.ProductCategoryEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private String brand;
    private ProductCategoryEnum category;
    private BigDecimal price;

}