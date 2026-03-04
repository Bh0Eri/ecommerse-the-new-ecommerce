package com.projeto.ecommerce.services.payment;

import com.projeto.ecommerce.dto.PaymentEntityDto;
import com.projeto.ecommerce.entities.PaymentEntity;
import com.projeto.ecommerce.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PaymentService implements PaymentServiceImp{

    private final PaymentRepository paymentRepository;

    @Override
    public PaymentEntityDto create(PaymentEntity dto) {
        return null;
    }

    @Override
    public Optional<PaymentEntity> showone(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<PaymentEntityDto> showall() {
        return List.of();
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public PaymentEntityDto update(UUID id, PaymentEntityDto dto) {
        return null;
    }
}
