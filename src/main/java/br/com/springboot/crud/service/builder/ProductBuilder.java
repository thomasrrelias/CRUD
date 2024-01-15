package br.com.springboot.crud.service.builder;

import br.com.springboot.crud.domain.dto.ProductRequestDto;
import br.com.springboot.crud.domain.dto.ProductResponseDto;
import br.com.springboot.crud.domain.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductBuilder {

    public Product toProduct(final ProductRequestDto productRequestDto){
        return Product.builder()
                .name(productRequestDto.getName())
                .value(BigDecimal.valueOf(Double.parseDouble(productRequestDto.getValue())))
                .build();
    }

    public ProductResponseDto toProductResponseDto(final Product product) {
        return ProductResponseDto.builder()
                .idProduct(product.getIdProduct())
                .name(product.getName())
                .value(product.getValue())
                .build();
    }
}
