package fi.metropolia.samuelms.Spring_API.services;

import fi.metropolia.samuelms.Spring_API.dto.ProductDto;
import fi.metropolia.samuelms.Spring_API.entities.Category;
import fi.metropolia.samuelms.Spring_API.entities.Product;
import fi.metropolia.samuelms.Spring_API.exceptions.ResourceNotFoundException;
import fi.metropolia.samuelms.Spring_API.repositories.CategoryRepository;
import fi.metropolia.samuelms.Spring_API.repositories.ProductRepository;
import fi.metropolia.samuelms.Spring_API.utils.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductDto getProductById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return ProductMapper.toDto(product);
    }

    public List<ProductDto> getAllProductsLike(String keyword) {
        List<Product> products = productRepository.findProductsByKeyword(keyword);
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(ProductMapper.toDto(product));
        }
        return productDtos;
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(ProductMapper.toDto(product));
        }
        return productDtos;
    }

    public ProductDto createProduct(Product product) {
        if (product.getCategory() == null) {
            throw new RuntimeException("Enter product category");
        }

        Category category = categoryRepository.findById(product.getCategory().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        product.setCategory(category);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.toDto(savedProduct);
    }
}
