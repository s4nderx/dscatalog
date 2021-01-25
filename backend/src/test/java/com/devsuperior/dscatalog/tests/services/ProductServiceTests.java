package com.devsuperior.dscatalog.tests.services;

import com.devsuperior.dscatalog.repositories.ProductRepository;
import com.devsuperior.dscatalog.services.ProductService;
import com.devsuperior.dscatalog.services.exceptions.DataBaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class ProductServiceTests {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    private long existId;
    private long nonExistId;
    private long dependentId;

    @BeforeEach
    void setUp() throws Exception{
        existId = 1L;
        nonExistId = 1000L;
        dependentId = 4L;

        Mockito.doNothing().when(repository).deleteById(existId);
        Mockito.doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(nonExistId);
        Mockito.doThrow(DataIntegrityViolationException.class).when(repository).deleteById(dependentId);
    }

    @Test
    public void deleteShouldThrowDataBaseExceptionWhenIdDoesNotExists() {

        Assertions.assertThrows(DataBaseException.class, () -> service.delete(dependentId));

        Mockito.verify(repository, Mockito.times(1)).deleteById(dependentId);

    }

    @Test
    public void deleteShouldThrowEmptyResourceNotFoundExceptionWhenIdDoesNotExists() {

        Assertions.assertThrows(ResourceNotFoundException.class, () -> service.delete(nonExistId));

        Mockito.verify(repository, Mockito.times(1)).deleteById(nonExistId);

    }

    @Test
    public void deleteShouldDoNothingWhenIdExists() {

        Assertions.assertDoesNotThrow(() -> service.delete(existId));

        Mockito.verify(repository, Mockito.times(1)).deleteById(existId);

    }


}
