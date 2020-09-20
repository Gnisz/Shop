package com.sda.dto;

import com.sda.domain.Category;
import lombok.Data;

@Data
public class UpdateProductDto {

    private Integer price;
    private Integer quantity;
    private String description;
}
