package com.example.orderservice.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    private double total;

    @OneToOne
    private Address shippingAddress;

    @OneToMany
    private ArrayList<Item> items;

    @OneToOne
    private Payment payment;

    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public Address getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public void setCustomerId(Long id) {
        this.customerId = id;
    }
    public Long getCustomerId() {
        return customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return customerId.equals(order.customerId);
    }

    @Override
    public int hashCode() {
        return customerId.hashCode();
    }
}
