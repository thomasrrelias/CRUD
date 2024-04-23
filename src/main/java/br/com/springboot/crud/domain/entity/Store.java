package br.com.springboot.crud.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "TB_STORE")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long idStore;

    @Getter
    @Setter
    private String StoreName;


    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "MERCHANT_ID", referencedColumnName = "idMerchant")
    private Merchant merchant;
}
