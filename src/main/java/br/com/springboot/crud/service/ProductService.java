package br.com.springboot.crud.service;

import br.com.springboot.crud.domain.dto.ProductRequestDto;
import br.com.springboot.crud.domain.dto.ProductResponseDto;
import br.com.springboot.crud.domain.entity.Product;
import br.com.springboot.crud.repository.ProductRepository;
import br.com.springboot.crud.service.builder.ProductBuilder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

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
    public List<ProductResponseDto> allProducts(){
        final List<Product> productList = repository.findAll();
        return productList.stream()
                .map(productBuilder::toProductResponseDto)
                .toList();
    }

    @Transactional
    public ProductResponseDto specificProduct(UUID id){
        return productBuilder.toProductResponseDto(repository.getReferenceById(id));
    }

    @Transactional
    public ProductResponseDto update(final Product newProdut) {
        if (repository.existsById(newProdut.getIdProduct())) {
            return productBuilder.toProductResponseDto(repository.save(newProdut));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with the id: " + newProdut.getIdProduct());
    }

    @Transactional
    public List<ProductResponseDto> deleteProduct(final UUID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return allProducts();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
