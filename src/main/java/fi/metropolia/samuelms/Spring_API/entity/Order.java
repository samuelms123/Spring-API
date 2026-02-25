package fi.metropolia.samuelms.Spring_API.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="orders")
public class Order {

    @Id
    private int id;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column
    private String status;

}
