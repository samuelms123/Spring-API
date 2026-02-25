package fi.metropolia.samuelms.Spring_API.controllers;

import fi.metropolia.samuelms.Spring_API.entity.Category;
import fi.metropolia.samuelms.Spring_API.repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping()
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category savedCategory = categoryRepository.save(category);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        if (!categoryRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        categoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
