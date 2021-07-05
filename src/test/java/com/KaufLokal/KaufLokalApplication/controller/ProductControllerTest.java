package com.KaufLokal.KaufLokalApplication.controller;

import com.KaufLokal.KaufLokalApplication.application.controller.ProductController;
import com.KaufLokal.KaufLokalApplication.application.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    ProductController productController;

    @Test
    void testController(){
        ProductDto productDto = new ProductDto();
        productDto.setName("Test Name_1");
        productDto.setDescription("Eine Beschreibung");
        productDto.setPrice(2.5);

        ResponseEntity<ProductDto> createProductDto = productController.createProduct(productDto);
        assertThat(createProductDto.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        ProductDto updateProduct = createProductDto.getBody();
        updateProduct.setName("Test Name_2");
        ResponseEntity<ProductDto> updatedProduct = productController.updateProduct(updateProduct);

        assertThat(updatedProduct.getBody().getName()).isEqualTo(updateProduct.getName());

        productController.deleteProduct(updatedProduct.getBody().getId());
    }
}
