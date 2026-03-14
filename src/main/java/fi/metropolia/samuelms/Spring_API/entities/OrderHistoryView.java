package fi.metropolia.samuelms.Spring_API.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_history_view")
public class OrderHistoryView {

    @EmbeddedId
    private OrderHistoryViewId id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "status")
    private String status;

    @Column(name = "quantity")
    private Integer quantity;


    public OrderHistoryViewId getId() {
        return id;
    }

    public void setId(OrderHistoryViewId id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return id != null ? id.getCustomerId() : null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getOrderDate() {
        return id != null ? id.getOrderDate() : null;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return id != null ? id.getProductName() : null;
    }
}
