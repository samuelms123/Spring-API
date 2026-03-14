package fi.metropolia.samuelms.Spring_API.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class OrderHistoryViewId implements Serializable {

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "name")
    private String productName;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderHistoryViewId that = (OrderHistoryViewId) o;
        return Objects.equals(customerId, that.customerId)
                && Objects.equals(orderDate, that.orderDate)
                && Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, orderDate, productName);
    }
}