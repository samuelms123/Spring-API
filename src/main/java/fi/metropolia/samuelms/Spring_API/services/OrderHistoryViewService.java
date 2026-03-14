package fi.metropolia.samuelms.Spring_API.services;

import fi.metropolia.samuelms.Spring_API.dto.OrderHistoryViewDto;
import fi.metropolia.samuelms.Spring_API.entities.OrderHistoryView;
import fi.metropolia.samuelms.Spring_API.repositories.OrderHistoryViewRepository;
import fi.metropolia.samuelms.Spring_API.utils.OrderHistoryViewMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderHistoryViewService {

    private final OrderHistoryViewRepository orderHistoryViewRepository;

    public OrderHistoryViewService(OrderHistoryViewRepository orderHistoryViewRepository) {
        this.orderHistoryViewRepository = orderHistoryViewRepository;
    }

    public List<OrderHistoryViewDto> getOrderHistoryByCustomerId(Integer customerId) {
        List<OrderHistoryView> historyRows = orderHistoryViewRepository
                .findByIdCustomerIdOrderByIdOrderDateDesc(customerId);

        List<OrderHistoryViewDto> historyDtos = new ArrayList<>();
        for (OrderHistoryView historyRow : historyRows) {
            historyDtos.add(OrderHistoryViewMapper.toDto(historyRow));
        }

        return historyDtos;
    }
}