package br.com.springboot.crud.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "TB_MERCHANT")
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private UUID idMerchant;

    @Getter
    @Setter
    private String merchantName;

    @Getter
    @Setter
    private DocumentEnum documentType;

    @Getter
    @Setter
    private String documentNumber;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private Boolean authenticated = Boolean.FALSE;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "merchant")
    private List<Store> stores;

}
