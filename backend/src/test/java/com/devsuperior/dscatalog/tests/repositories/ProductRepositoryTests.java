package com.devsuperior.dscatalog.tests.repositories;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.repositories.CategoryRepository;
import com.devsuperior.dscatalog.repositories.ProductRepository;
import com.devsuperior.dscatalog.tests.factory.ProductFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    private long existingId;
    private long nonExistingId;
    private long countTotalProducts;
    private long countPCGamerProducts;
    private long countComputadores;
    private PageRequest pageable;

    @BeforeEach
    void setUp() throws Exception{
       existingId = 1L;
       nonExistingId = 1000L;
       countTotalProducts = 25L;
       countPCGamerProducts = 21L;
       pageable = PageRequest.of(0, 10);
       countComputadores = 23L;
    }

    @Test
    public void findShouldReturnAnyProductWhenCategoryNotExists(){
        String name = "";

        Page<Product> result = repository.find(Collections.singletonList(new Category(10L, "Não existente")), name, pageable);

        Assertions.assertTrue(result.isEmpty());
        Assertions.assertEquals(0L, result.getTotalElements());
    }

    @Test
    public void findShouldReturnProductsWithSelectedCategoryId(){
        String name = "";
        Page<Product> result = repository.find(Collections.singletonList(new Category(3L, "Computadores")), name, pageable);

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(countComputadores, result.getTotalElements());
    }


    @Test
    public void findShouldReturnAllProductsWhenNameIsEmpty(){
        String name = "";
        Page<Product> result = repository.find(null, name, pageable);

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(countTotalProducts, result.getTotalElements());
    }


    @Test
    public void findShouldReturnProductsWhenNameExistsIgnoreCase(){
        String name = "pC gaMeR";
        Page<Product> result = repository.find(null, name, pageable);

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(countPCGamerProducts, result.getTotalElements());
    }

    @Test
    public void findShouldReturnProductsWhenNameExists(){
        String name = "PC Gamer";
        Page<Product> result = repository.find(null, name, pageable);

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(countPCGamerProducts, result.getTotalElements());
    }

    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull(){

        Product product  = ProductFactory.createProduct();
        product.setId(null);

        product = repository.save(product);

        Optional<Product> result = repository.findById(product.getId());

        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals(countTotalProducts + 1, product.getId());
        Assertions.assertTrue(result.isPresent());
        Assertions.assertSame(product, result.get());
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {

        repository.deleteById(existingId);
        Optional<Product> result = repository.findById(existingId);
        Assertions.assertFalse(result.isPresent());

    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {

        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(nonExistingId);
        });

    }




}
