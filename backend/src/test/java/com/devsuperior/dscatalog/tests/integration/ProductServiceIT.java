package com.devsuperior.dscatalog.tests.integration;

import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.services.ProductService;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ProductServiceIT {

    @Autowired
    private ProductService service;

    private long existId;
    private long nonExistId;
    private long countTotalProducts;
    private long countPCGamerProducts;
    private PageRequest pageable;

    @BeforeEach
    void setUp() throws Exception{
        existId = 1L;
        nonExistId = 1000L;
        countTotalProducts = 25L;
        countPCGamerProducts = 21L;
        pageable = PageRequest.of(0, 10);
    }

    @Test
    public void deleteShouldThrowEmptyResourceNotFoundExceptionWhenIdDoesNotExists() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> service.delete(nonExistId));
    }

    @Test
    public void deleteShouldDoNothingWhenIdExists() {
        Assertions.assertDoesNotThrow(() -> service.delete(existId));
    }


    @Test
    public void findAllPagedShouldReturnNothingWhenNameDoesNotExist(){
        String name = "Camera";
        Page<ProductDTO> result = service.findAllPaged(0L, name, pageable);

        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void findAllPagedShouldReturnAllProductsWhenNameIsEmpty(){
        String name = "";
        Page<ProductDTO> result = service.findAllPaged(0L, name, pageable);

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(countTotalProducts, result.getTotalElements());
    }


    @Test
    public void findAllPagedShouldReturnProductsWhenNameExistsIgnoreCase(){
        String name = "pC gaMeR";
        Page<ProductDTO> result = service.findAllPaged(0L, name, pageable);

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(countPCGamerProducts, result.getTotalElements());
    }

}
