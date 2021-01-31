package com.devsuperior.dscatalog.tests.factory;

import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;

import java.time.Instant;

public class ProductFactory {

    public static Product createProduct() {
        Product product = new Product(1L, "Phone", "Good Phone", 1000.00, "https://img.com/img.png", Instant.now());
        product.getCategories().add(new Category(1L, null));
        return product;
    }

    public static ProductDTO createProductDTO(){
        Product product = createProduct();
        return new ProductDTO(createProduct(), product.getCategories());
    }

    public static ProductDTO createProductDTO(Long id){
        ProductDTO dto = createProductDTO();
        dto.setId(1L);
        return dto;
    }
}
