package com.sda.dto;

import com.sda.domain.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
public class CreateProductDto {

    @NotNull
    private String name;

    @NotNull
    @Min(1)
    private Integer price;

    @NotNull
    @Min(1)
    private Integer quantity;

    @NotNull
    private Category category;

    @NotNull
    private String description;

}
