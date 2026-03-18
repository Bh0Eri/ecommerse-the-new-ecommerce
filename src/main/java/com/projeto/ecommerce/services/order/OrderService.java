package com.projeto.ecommerce.services.order;

import com.projeto.ecommerce.dto.OrderEntityDto;
import com.projeto.ecommerce.entities.OrderEntity;

import com.projeto.ecommerce.exceptions.ResourceNotFoundException;
import com.projeto.ecommerce.repositories.OrderRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class OrderService implements OrderServiceImp {

    private final OrderRepository orderRepository;


    @Override
    public OrderEntityDto create(OrderEntityDto dto) {

        OrderEntity order = new OrderEntity();

        order.setClient(dto.getClient());
        order.setStatus(dto.getStatus());
        order.setMoment(dto.getMoment());
        order.setPayment(dto.getPayment());

        OrderEntity saved = orderRepository.save(order);

        return toDto(saved);
    }

    @Override
    public Optional<OrderEntity> showone(UUID id) {

        return orderRepository.findById(id);
    }

    @Override
    public List<OrderEntityDto> showall() {
        return orderRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public void delete(UUID id) {

        orderRepository.deleteById(id);

    }

    @Override
    public OrderEntityDto update(UUID id, OrderEntityDto dto) {

        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("404 Not found"));

        order.setClient(dto.getClient());

        OrderEntity saved = orderRepository.save(order);

        return toDto(saved);
    }



    private OrderEntityDto toDto(OrderEntity order) {
    OrderEntityDto dto = new OrderEntityDto();
    dto.setClient(order.getClient());
    dto.setStatus(order.getStatus());
    dto.setMoment(order.getMoment());
    dto.setPayment(order.getPayment());
    return dto;
    }

}
