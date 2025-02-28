package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;
    private final String modelAttributeName = "product";
    private final String backToProductList = "redirect:list";

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute(modelAttributeName, product);
        return "CreateProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product) {
        service.create(product);
        return backToProductList;
    }

    @GetMapping("/edit/{id}")
    public String editProductPage(@PathVariable("id") String id, Model model) {
        Product product = service.findByID(id);
        model.addAttribute(modelAttributeName, product);
        return "EditProduct";
    }

    @PostMapping("/edit")
    public String editProductPost(@ModelAttribute Product product) {
        service.edit(product.getProductId(), product.getProductName(), product.getProductQuantity());
        return backToProductList;
    }

    @GetMapping("/delete/{id}")
    public String deleteProductPage(@PathVariable("id") String id, Model model) {
        Product product = service.findByID(id);
        model.addAttribute(modelAttributeName, product);
        return "DeleteProduct";
    }

    @PostMapping("/delete")
    public String deleteProductPost(@RequestParam("productId") String id) {
        service.delete(id);
        return backToProductList;
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "ProductList";
    }
}