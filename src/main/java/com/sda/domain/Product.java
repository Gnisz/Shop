package com.sda.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
public class Product {


    @Setter
    private Long id;

    private String name;

    @Setter
    private Integer price;

    @Setter
    private Integer quantity;

    private Category category;

    @Setter
    private String description;

    private LocalDateTime creationTime;

}
