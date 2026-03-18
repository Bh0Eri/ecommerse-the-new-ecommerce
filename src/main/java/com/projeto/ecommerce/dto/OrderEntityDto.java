package com.projeto.ecommerce.dto;


import com.projeto.ecommerce.entities.PaymentEntity;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.enums.StatusOrder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntityDto{
    private LocalDate moment;
    @NotNull
    private StatusOrder status;
    @NotNull
    private UserEntity client;
    @NotNull
    private PaymentEntity payment;


}