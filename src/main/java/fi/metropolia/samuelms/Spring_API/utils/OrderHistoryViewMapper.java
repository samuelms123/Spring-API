package fi.metropolia.samuelms.Spring_API.utils;

import fi.metropolia.samuelms.Spring_API.dto.OrderHistoryViewDto;
import fi.metropolia.samuelms.Spring_API.entities.OrderHistoryView;

public class OrderHistoryViewMapper {

    private OrderHistoryViewMapper() {
    }

    public static OrderHistoryViewDto toDto(OrderHistoryView history) {
        if (history == null) {
            return null;
        }

        OrderHistoryViewDto dto = new OrderHistoryViewDto();
        dto.setOrderDate(history.getOrderDate());
        dto.setStatus(history.getStatus());
        dto.setQuantity(history.getQuantity());
        dto.setProductName(history.getProductName());
        return dto;
    }
}