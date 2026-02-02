package senai.ecommerse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import senai.ecommerse.enums.OrderStatus;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDate moment;
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "costumer_id")
    private User costumer;

}
