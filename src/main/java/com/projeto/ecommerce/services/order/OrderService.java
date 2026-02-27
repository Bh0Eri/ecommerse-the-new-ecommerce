package com.projeto.ecommerce.services.order;

import com.projeto.ecommerce.dto.OrderEntityDto;
import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService  implements OrderServiceImp{


    private final OrderRepository orderRepository;


    @Override
    public OrderEntityDto create(OrderEntity dto) {
        return null;
    }

    @Override
    public Optional<OrderEntity> showone(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<OrderEntityDto> showall() {
        return List.of();
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public OrderEntityDto update(UUID id, OrderEntityDto dto) {
        return null;
    }
}
