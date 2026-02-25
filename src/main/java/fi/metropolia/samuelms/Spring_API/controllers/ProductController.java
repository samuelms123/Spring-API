package fi.metropolia.samuelms.Spring_API.controllers;


import fi.metropolia.samuelms.Spring_API.entity.Category;
import fi.metropolia.samuelms.Spring_API.entity.Product;
import fi.metropolia.samuelms.Spring_API.repositories.CategoryRepository;
import fi.metropolia.samuelms.Spring_API.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        return productRepository.findById(id)
                .map(product -> ResponseEntity.ok(product))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        if (product.getCategory() != null && product.getCategory().getId() != null) {
            Category category = categoryRepository.findById(product.getCategory().getId()).orElse(null);
            if (category == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category not found");
            }
            product.setCategory(category);
        }

        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
}
