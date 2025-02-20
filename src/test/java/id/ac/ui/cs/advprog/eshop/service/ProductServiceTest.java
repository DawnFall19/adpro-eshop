package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.List;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    private Iterator<Product> productIterator;
    @InjectMocks
    ProductServiceImpl productServiceImpl;
    @BeforeEach
    void setUp() {
    }
    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        when(productRepository.create(product))
            .thenReturn(product);
        when(productRepository.findAll())
            .thenReturn(Collections.singletonList(product).iterator());
        when(productRepository.findByID(product.getProductId()))
            .thenReturn(product);

        Product savedProduct = productServiceImpl.create(product);
        assertNotNull(savedProduct);
        assertEquals(savedProduct.getProductId(), product.getProductId());
        assertEquals(savedProduct.getProductName(), product.getProductName());
        assertEquals(savedProduct.getProductQuantity(), product.getProductQuantity());

        List<Product> productList = productServiceImpl.findAll();
        assertFalse(productList.isEmpty());
        assertTrue(productList.contains(savedProduct));

        Product foundProduct = productServiceImpl.findByID("eb558e9f-1c39-460e-8860-71af6af63bd6");
        assertEquals(foundProduct.getProductId(), product.getProductId());
        assertEquals(foundProduct.getProductName(), product.getProductName());
        assertEquals(foundProduct.getProductQuantity(), product.getProductQuantity());
    }
    @Test
    void testEdit() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        when(productRepository.create(product)).thenReturn(product);
        Product savedProduct = productServiceImpl.create(product);
        assertNotNull(savedProduct);

        Product editedProductMock = new Product();
        editedProductMock.setProductId(product.getProductId());
        editedProductMock.setProductName("Sampo Cap Rusdi");
        editedProductMock.setProductQuantity(200);

        when(productRepository.edit(product.getProductId(), "Sampo Cap Rusdi", 200))
            .thenReturn(editedProductMock);

        Product editedProduct = productServiceImpl.edit(savedProduct.getProductId(), "Sampo Cap Rusdi", 200);
        assertNotNull(editedProduct);

        assertEquals("Sampo Cap Rusdi", editedProduct.getProductName());
        assertEquals(200, editedProduct.getProductQuantity());
    }
    @Test
    void testDelete() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        when(productRepository.create(product)).thenReturn(product);

        Product savedProduct = productServiceImpl.create(product);

        when(productRepository.findAll())
            .thenReturn(Collections.singletonList(product).iterator());

        List<Product> productList = productServiceImpl.findAll();
        assertFalse(productList.isEmpty());
        productServiceImpl.delete(savedProduct.getProductId());

        when(productRepository.findAll())
            .thenReturn(Collections.emptyIterator());

        productList = productServiceImpl.findAll();
        assertTrue(productList.isEmpty());
    }
}