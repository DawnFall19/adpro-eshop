package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    public Product create(Product product);
    public Product edit(String id, String newName, int newQuantity);
    public void delete(String id);
    public List<Product> findAll();
    public Product findByID(String id);
}