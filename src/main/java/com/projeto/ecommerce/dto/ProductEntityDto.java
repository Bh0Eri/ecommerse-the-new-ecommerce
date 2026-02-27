package com.projeto.ecommerce.dto;

import com.projeto.ecommerce.entities.ProductEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ProductEntity}
 */
@Value
public class ProductEntityDto implements Serializable {
    @NotNull
    @Size(min = 6, max = 40)
    String name;
    @NotEmpty
    String description;
    @Min(message = "Not accept less than 1", value = 1)
    double price;
}