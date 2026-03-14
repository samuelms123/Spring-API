package fi.metropolia.samuelms.Spring_API.utils;

import fi.metropolia.samuelms.Spring_API.dto.OrderDto;
import fi.metropolia.samuelms.Spring_API.entities.Order;

import java.util.Date;

public class OrderMapper {

    private OrderMapper() {
    }

    public static OrderDto toDto(Order order) {
        if (order == null) {
            return null;
        }

        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setOrderDate(new Date());
        dto.setDeliveryDate(order.getDeliveryDate());
        dto.setStatus(order.getStatus());
        dto.setCustomer(CustomerMapper.toDto(order.getCustomer()));
        dto.setCustomerAddress(CustomerAddressMapper.toDto(order.getCustomerAddress()));
        return dto;
    }
}