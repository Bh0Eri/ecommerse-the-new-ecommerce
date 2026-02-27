package com.projeto.ecommerce.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.projeto.ecommerce.entities.CategoryEntity}
 */
@Value
public class CategoryEntityDto implements Serializable {
    @NotNull
    String name;

    @NotNull
    Set<ProductEntityDto> products;
}