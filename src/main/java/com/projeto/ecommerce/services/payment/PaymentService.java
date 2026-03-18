package com.projeto.ecommerce.services.payment;

import com.projeto.ecommerce.dto.PaymentEntityDto;
import com.projeto.ecommerce.entities.PaymentEntity;
import com.projeto.ecommerce.exceptions.ResourceNotFoundException;
import com.projeto.ecommerce.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService implements PaymentServiceImp {

    private final PaymentRepository paymentRepository;

    @Override
    public PaymentEntityDto create(PaymentEntity payment) {

        PaymentEntity saved = paymentRepository.save(payment);

        return new PaymentEntityDto();
    }

    @Override
    public Optional<PaymentEntity> showone(UUID id) {

        return paymentRepository.findById(id);
    }

    @Override
    public List<PaymentEntityDto> showall() {

        return paymentRepository.findAll()
                .stream()
                .map(payment -> new PaymentEntityDto())
                .toList();
    }

    @Override
    public void delete(UUID id) {

        paymentRepository.deleteById(id);
    }

    @Override
    public PaymentEntityDto update(UUID id, PaymentEntityDto dto) {

        PaymentEntity payment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found"));

        payment.setMoment(dto.getMoment());

        PaymentEntity updated = paymentRepository.save(payment);

        return new PaymentEntityDto();
    }
}