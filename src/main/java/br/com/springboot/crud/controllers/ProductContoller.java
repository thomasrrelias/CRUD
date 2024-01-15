package br.com.springboot.crud.controllers;

import br.com.springboot.crud.domain.dto.ProductRequestDto;
import br.com.springboot.crud.domain.dto.ProductResponseDto;
import br.com.springboot.crud.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/product")
public class ProductContoller {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDto> saveProduct(@RequestBody  @Valid ProductRequestDto productRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productRequestDto));
    }

}
