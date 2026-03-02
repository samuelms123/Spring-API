package fi.metropolia.samuelms.Spring_API.services;

import fi.metropolia.samuelms.Spring_API.dto.CategoryDto;
import fi.metropolia.samuelms.Spring_API.entities.Category;
import fi.metropolia.samuelms.Spring_API.exceptions.ResourceAlreadyExistsException;
import fi.metropolia.samuelms.Spring_API.exceptions.ResourceNotFoundException;
import fi.metropolia.samuelms.Spring_API.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDto createCategory(Category category) {
        if (categoryRepository.existsById(category.getId())) {
            throw new ResourceAlreadyExistsException("Category already exists");
        }

        Category saved = categoryRepository.save(category);
        return mapToDto(saved);
    }

    public void deleteCategory(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        categoryRepository.delete(category);
    }

    public CategoryDto getCategoryById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        return mapToDto(category);
    }

    private CategoryDto mapToDto(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        return dto;
    }
}
