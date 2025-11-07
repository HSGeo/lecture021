package com.example.api_service.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.product_service.dto.CreateProductDto;
import com.example.product_service.dto.ProductDto;
import com.example.product_service.dto.UpdateProductDto;
import com.example.product_service.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService; // build.gradle에서 의존성에 implementation에서 produc를 적어놔서 스캔할 수 있음
    
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        String bar = "bar";
        return ResponseEntity.ok(productService.getAllProducts());
    }   
    
 // 상품 상세
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProduct(
            @PathVariable("id") int id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }
 // 상품 등록
    @PostMapping("/products")
    public ResponseEntity<Void> createProduct(@RequestBody @Valid CreateProductDto createProductDto) {
        productService.createProduct(createProductDto);
        URI uri = ServletUriComponentsBuilder //사용자에게 로케이션 주소를 주기 위해서 만듬
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(createProductDto.getId())
                        .toUri();
        return ResponseEntity.created(uri).build();
    }
    
    
    @PutMapping("/products/{id}")
    public ResponseEntity<Void> updataProduct(
            @PathVariable("id") int id,
            @RequestBody @Valid UpdateProductDto updateProductDto
            ){
       productService.updateProduct(id, updateProductDto);
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable("id") int id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
