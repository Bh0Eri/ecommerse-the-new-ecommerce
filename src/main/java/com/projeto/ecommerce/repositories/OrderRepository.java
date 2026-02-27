package com.projeto.ecommerce.repositories;

import com.projeto.ecommerce.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

    OrderEntity findAllById(UUID id);


}
