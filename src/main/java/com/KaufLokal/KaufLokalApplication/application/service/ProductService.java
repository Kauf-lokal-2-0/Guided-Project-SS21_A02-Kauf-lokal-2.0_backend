package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.ProductDto;
import com.KaufLokal.KaufLokalApplication.domain.model.Product;
import com.KaufLokal.KaufLokalApplication.domain.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService implements IDefaultService<Product, ProductDto>{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> findAll() {
        productRepository.findAll();
        return mapToDto(productRepository.findAll());
    }

    @Override
    public ProductDto findById(UUID id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent())
        {
            return mapToDto(productOptional.get());
        }
        return null;
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        return mapToDto(productRepository.save(mapDtoToObject(productDto)));
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        Optional<Product> productOptional = productRepository.findById(productDto.getId());
        if (productOptional.isPresent())
        {
            Product product = productOptional.get();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(productDto, product);
            productRepository.save(product);
            return mapToDto(product);
        }
        return productDto;
    }

    @Override
    public void delete(UUID id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            productRepository.delete(product);
        }
    }

    public List<ProductDto> mapToDto(List<Product> products) {
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product: products) {
            productDtos.add(mapToDto(product));
        }
        return productDtos;
    }

    public ProductDto mapToDto(Product product){
        ModelMapper modelMapper = new ModelMapper();
        ProductDto productDto = new ProductDto();
        modelMapper.map(product,productDto);
        return productDto;
    }

    public Product mapDtoToObject(ProductDto productDto, Product product) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(productDto, product);
        return product;
    }

    public Product mapDtoToObject(ProductDto productDto) {
        return mapDtoToObject(productDto, new Product());
    }
}
