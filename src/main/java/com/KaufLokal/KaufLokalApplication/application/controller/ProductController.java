package com.KaufLokal.KaufLokalApplication.application.controller;

import com.KaufLokal.KaufLokalApplication.application.dto.ProductDto;
import com.KaufLokal.KaufLokalApplication.application.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "Product Controller")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Get all products")
    @GetMapping("/product")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        logger.debug("GET: Products");
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get product by ID")
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable UUID id)  {
        logger.debug("GET: Product by ID");
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create an new products")
    @PostMapping("/product")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        logger.debug("POST: Product");
        return new ResponseEntity<>(productService.create(productDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update an product")
    @PutMapping("/product")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        logger.debug("PUT: Product");
        return new ResponseEntity<>(productService.update(productDto), HttpStatus.OK);
    }
    @ApiOperation(value = "Delete an product")
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        logger.debug("DELETE: Product");
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
