package com.projeto.ecommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDate moment;

    //NÃO ESTOU ENTENDENDO
    @OneToOne
    @MapsId
    private OrderEntity order;

}
