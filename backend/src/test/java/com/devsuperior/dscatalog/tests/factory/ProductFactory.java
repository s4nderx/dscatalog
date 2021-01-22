package com.devsuperior.dscatalog.tests.factory;

import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Product;

import java.time.Instant;

public class ProductFactory {

    public static Product createProduct() {
        return new Product(1L, "Phone", "Good Phone", 1000.00, "https://img.com/img.png", Instant.now());
    }

    public static ProductDTO createProductDTO(){
        return new ProductDTO(createProduct());
    }
}
