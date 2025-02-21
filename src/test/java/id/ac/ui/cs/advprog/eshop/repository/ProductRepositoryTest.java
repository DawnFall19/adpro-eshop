package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {
    @InjectMocks
    ProductRepository productRepository;

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
        Product product2 = new Product();
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);
        productIterator = productRepository.findAll();
        savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertEquals(product2.getProductName(), savedProduct.getProductName());
        assertEquals(product2.getProductQuantity(), savedProduct.getProductQuantity());
        assertNotNull(savedProduct.getProductId());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfNull() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditAndFindId() {
        Product savedProduct = productRepository.findByID("eb558e9f-1c39-460e-8860-71af6af63bd6");
        assertNull(savedProduct);
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);
        productRepository.edit("eb558e9f-1c39-460e-8860-71af6af63bd6", "Sampo Cap Bambang", 250);
        savedProduct = productRepository.findByID("eb558e9f-1c39-460e-8860-71af6af63bd6");
        assertEquals("Sampo Cap Bambang", savedProduct.getProductName());
        assertEquals(250, savedProduct.getProductQuantity());
        productRepository.edit("eb558e9f-1c39-460e-8860-71af6af63bd6", "Sampo Cap Siti", 250);
        savedProduct = productRepository.findByID("eb558e9f-1c39-460e-8860-71af6af63bd6");
        assertEquals("Sampo Cap Siti", savedProduct.getProductName());
        assertEquals(250, savedProduct.getProductQuantity());
        productRepository.edit("eb558e9f-1c39-460e-8860-71af6af63bd6", "Sampo Cap Beruang", 300);
        savedProduct = productRepository.findByID("eb558e9f-1c39-460e-8860-71af6af63bd6");
        assertEquals("Sampo Cap Beruang", savedProduct.getProductName());
        assertEquals(300, savedProduct.getProductQuantity());
        savedProduct = productRepository.findByID("eh972h1j-1j29-078x-1046-43cn4an29ei1");
        assertNull(savedProduct);
    }

    @Test
    void testFindAllAfterEdit() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);
        productRepository.edit("eb558e9f-1c39-460e-8860-71af6af63bd6", "Sampo Cap Bambang", 150);
        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals("Sampo Cap Bambang", savedProduct.getProductName());
        assertEquals(150, savedProduct.getProductQuantity());
        productRepository.edit("eb558e9f-1c39-460e-8860-71af6af63bd6", "Sampo Cap Udin", 150);
        productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals("Sampo Cap Udin", savedProduct.getProductName());
        assertEquals(150, savedProduct.getProductQuantity());
        productRepository.edit("eb558e9f-1c39-460e-8860-71af6af63bd6", "Sampo Cap Bombon", 200);
        productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals("Sampo Cap Bombon", savedProduct.getProductName());
        assertEquals(200, savedProduct.getProductQuantity());
    }

    @Test
    void testDelete() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);
        productRepository.delete("eb558e9f-1c39-460e-8860-71af6af63bd6");
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDeleteAfterEdit() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);
        productRepository.edit("eb558e9f-1c39-460e-8860-71af6af63bd6", "Sampo Cap Dodi", 500);
        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        productRepository.delete("eb558e9f-1c39-460e-8860-71af6af63bd6");
        productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }
}