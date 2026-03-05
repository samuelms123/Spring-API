package fi.metropolia.samuelms.Spring_API.controllers;

import fi.metropolia.samuelms.Spring_API.dto.ProductDto;
import fi.metropolia.samuelms.Spring_API.entities.Product;
import fi.metropolia.samuelms.Spring_API.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Integer id) {
        ProductDto dto = productService.getProductById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts(
            @RequestParam(required = false) String search) {

        if (search != null) {
            return ResponseEntity.ok(
                    productService.getAllProductsLike(search)
            );
        }

        return ResponseEntity.ok(
                productService.getAllProducts()
        );
    }

    @PostMapping()
    public ResponseEntity<ProductDto> createProduct(@RequestBody Product product) {
        ProductDto dto = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
