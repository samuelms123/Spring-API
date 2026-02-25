package fi.metropolia.samuelms.Spring_API.entity;

import jakarta.persistence.*;

@Entity
@Table(name="customeraddresses")
public class CustomerAddress {

    @Id
    private int id;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "postal_code")
    private String postalCode;

    @Column
    private String city;

    @Column
    private String country;

    @ManyToOne
    Customer customer;

    public CustomerAddress() {}

    public Integer getId() {
        return id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Customer getCustomer() {
        return customer;
    }
}
