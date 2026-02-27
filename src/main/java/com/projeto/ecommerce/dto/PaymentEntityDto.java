package com.projeto.ecommerce.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.projeto.ecommerce.entities.PaymentEntity}
 */
@Value
public class PaymentEntityDto implements Serializable {
    @NotNull
    LocalDate moment;
    @NotNull
    OrderEntityDto order;
}