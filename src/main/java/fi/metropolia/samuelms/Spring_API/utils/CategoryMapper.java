package fi.metropolia.samuelms.Spring_API.utils;

import fi.metropolia.samuelms.Spring_API.dto.CategoryDto;
import fi.metropolia.samuelms.Spring_API.entities.Category;

public class CategoryMapper {

    private CategoryMapper() {
    }

    public static CategoryDto toDto(Category category) {
        if (category == null) {
            return null;
        }

        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        return dto;
    }
}