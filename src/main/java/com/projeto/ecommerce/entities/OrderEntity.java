package com.projeto.ecommerce.entities;

import com.projeto.ecommerce.enums.StatusOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDate moment;
    private StatusOrder status;
//  Anotation pra falar que é uma relação de muitos pra 1
    @ManyToOne
//  define qual coluna será usada como chave estrangeira na tabela
    @JoinColumn(name  = "cliente_id")
    private UserEntity client;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private PaymentEntity payment;


}
