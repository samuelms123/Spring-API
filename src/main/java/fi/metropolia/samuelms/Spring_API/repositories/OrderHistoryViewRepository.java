package fi.metropolia.samuelms.Spring_API.repositories;

import fi.metropolia.samuelms.Spring_API.entities.OrderHistoryView;
import fi.metropolia.samuelms.Spring_API.entities.OrderHistoryViewId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderHistoryViewRepository extends JpaRepository<OrderHistoryView, OrderHistoryViewId> {
    List<OrderHistoryView> findByIdCustomerIdOrderByIdOrderDateDesc(Integer customerId);
}