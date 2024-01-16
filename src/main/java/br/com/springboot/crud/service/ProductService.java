package br.com.springboot.crud.service;

import br.com.springboot.crud.domain.dto.ProductRequestDto;
import br.com.springboot.crud.domain.dto.ProductResponseDto;
import br.com.springboot.crud.domain.entity.Product;
import br.com.springboot.crud.repository.ProductRepository;
import br.com.springboot.crud.service.builder.ProductBuilder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ProductBuilder productBuilder;

    @Transactional
    public ProductResponseDto save(final ProductRequestDto productRequest) {
        final Product product = productBuilder.toProduct(productRequest);
        return productBuilder.toProductResponseDto(repository.save(product));
    }

    @Transactional
    public List<ProductResponseDto> getSpecificProduct(){
        final List<Product> productList = repository.findAll();
        return productList.stream()
                .map(productBuilder::toProductResponseDto)
                .toList();
    }

}
