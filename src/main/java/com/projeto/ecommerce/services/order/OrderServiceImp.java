package com.projeto.ecommerce.services.order;

import com.projeto.ecommerce.dto.OrderEntityDto;
import com.projeto.ecommerce.entities.OrderEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderServiceImp {

    OrderEntityDto create(OrderEntity dto);

    Optional<OrderEntity> showone(UUID id);

    List<OrderEntityDto> showall();

    void delete(UUID id);

    OrderEntityDto update(UUID id, OrderEntityDto dto);


}
