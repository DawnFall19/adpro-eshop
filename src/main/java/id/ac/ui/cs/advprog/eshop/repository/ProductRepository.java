package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        product.setProductId(UUID.randomUUID().toString());
        productData.add(product);
        return product;
    }

    public Product edit(String id, String newName, int newQuantity) {
        Product currentProduct = findByID(id);
        currentProduct.setProductName(newName);
        currentProduct.setProductQuantity(newQuantity);
        return currentProduct;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findByID(String id) {
        for (Product product : productData) {
            if (product.getProductId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}