package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.dto.PaymentEntityDto;
import com.projeto.ecommerce.entities.PaymentEntity;
import com.projeto.ecommerce.exceptions.ResourceNotFoundException;
import com.projeto.ecommerce.services.payment.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentEntityDto> create(@Valid @RequestBody PaymentEntity payment){

        PaymentEntityDto created = paymentService.create(payment);

        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentEntity> showOne(@PathVariable UUID id){

        PaymentEntity payment = paymentService.showone(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found"));

        return ResponseEntity.ok(payment);
    }

    @GetMapping
    public ResponseEntity<List<PaymentEntityDto>> showAll(){

        List<PaymentEntityDto> payments = paymentService.showall();

        return ResponseEntity.ok(payments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentEntityDto> update(
            @PathVariable UUID id,
            @Valid @RequestBody PaymentEntityDto dto){

        PaymentEntityDto updated = paymentService.update(id, dto);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){

        paymentService.delete(id);

        return ResponseEntity.noContent().build();
    }

}