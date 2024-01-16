package br.com.springboot.crud.controllers;

import br.com.springboot.crud.domain.dto.ProductRequestDto;
import br.com.springboot.crud.domain.dto.ProductResponseDto;
import br.com.springboot.crud.domain.entity.Product;
import br.com.springboot.crud.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/product")
public class ProductContoller {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDto> saveProduct(@RequestBody @Valid ProductRequestDto productRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.allProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getSpecificProduct(@PathVariable("id") final UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.specificProduct(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<ProductResponseDto> updateProduct (@RequestBody Product product) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productService.update(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<ProductResponseDto>> delete(@PathVariable("id") final UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(id));
    }

}
