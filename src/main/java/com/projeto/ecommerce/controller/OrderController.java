package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.dto.OrderEntityDto;
import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.exceptions.ResourceNotFoundException;
import com.projeto.ecommerce.services.order.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderEntityDto> create(@Valid @RequestBody OrderEntityDto dto) {

        OrderEntityDto created = orderService.create(dto);

        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<OrderEntityDto>> showAll() {

        List<OrderEntityDto> orders = orderService.showall();

        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> showOne(@PathVariable UUID id) {

        OrderEntity order = orderService.showone(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        return ResponseEntity.ok(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderEntityDto> update(
            @PathVariable UUID id,
            @Valid @RequestBody OrderEntityDto dto) {

        OrderEntityDto updated = orderService.update(id, dto);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {

        orderService.delete(id);

        return ResponseEntity.noContent().build();
    }

}