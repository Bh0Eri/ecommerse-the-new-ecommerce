package senai.ecommerse.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;


    @ManyToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<>();


}
