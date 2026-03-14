package fi.metropolia.samuelms.Spring_API.utils;

import fi.metropolia.samuelms.Spring_API.dto.ProductDto;
import fi.metropolia.samuelms.Spring_API.entities.Product;

public class ProductMapper {

    private ProductMapper() {
    }

    public static ProductDto toDto(Product product) {
        if (product == null) {
            return null;
        }

        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setStockQuantity(product.getStockQuantity());
        dto.setPrice(product.getPrice());
        dto.setCategory(CategoryMapper.toDto(product.getCategory()));
        return dto;
    }
}