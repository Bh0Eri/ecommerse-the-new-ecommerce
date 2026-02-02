package senai.ecommerse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import senai.ecommerse.enums.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @Column(unique = true)
    private String email;

    private String telephone;


    private String password;

    @Enumerated(EnumType.STRING)
    private Role roles;

    @OneToMany(mappedBy = "costumer")
    private List<Orders> order = new ArrayList<>();
}
