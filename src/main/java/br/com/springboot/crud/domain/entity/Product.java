package br.com.springboot.crud.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private UUID idProduct;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private BigDecimal value;

}
