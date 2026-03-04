package com.projeto.ecommerce.services.payment;

import com.projeto.ecommerce.dto.PaymentEntityDto;
import com.projeto.ecommerce.entities.PaymentEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentServiceImp {

    PaymentEntityDto create(PaymentEntity dto);

    Optional<PaymentEntity> showone(UUID id);

    List<PaymentEntityDto> showall();

    void delete(UUID id);

    PaymentEntityDto update(UUID id, PaymentEntityDto dto);
}
