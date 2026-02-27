package com.projeto.ecommerce.dto;


import com.projeto.ecommerce.entities.PaymentEntity;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.enums.StatusDoPedido;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class OrderEntityDto{
    private LocalDate moment;
    @NotNull
    private StatusDoPedido status;
    @NotNull
    private UserEntity client;
    @NotNull
    private PaymentEntity payment;


}