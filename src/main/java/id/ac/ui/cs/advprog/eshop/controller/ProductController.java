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
    private static final String MODEL_ATTRIBUTE_NAME = "product";
    private static final String BACK_TO_PRODUCT_LIST = "redirect:list";

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute(MODEL_ATTRIBUTE_NAME, product);
        return "CreateProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product) {
        service.create(product);
        return BACK_TO_PRODUCT_LIST;
    }

    @GetMapping("/edit/{id}")
    public String editProductPage(@PathVariable("id") String id, Model model) {
        Product product = service.findByID(id);
        model.addAttribute(MODEL_ATTRIBUTE_NAME, product);
        return "EditProduct";
    }

    @PostMapping("/edit")
    public String editProductPost(@ModelAttribute Product product) {
        service.edit(product.getProductId(), product.getProductName(), product.getProductQuantity());
        return BACK_TO_PRODUCT_LIST;
    }

    @GetMapping("/delete/{id}")
    public String deleteProductPage(@PathVariable("id") String id, Model model) {
        Product product = service.findByID(id);
        model.addAttribute(MODEL_ATTRIBUTE_NAME, product);
        return "DeleteProduct";
    }

    @PostMapping("/delete")
    public String deleteProductPost(@RequestParam("productId") String id) {
        service.delete(id);
        return BACK_TO_PRODUCT_LIST;
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "ProductList";
    }
}