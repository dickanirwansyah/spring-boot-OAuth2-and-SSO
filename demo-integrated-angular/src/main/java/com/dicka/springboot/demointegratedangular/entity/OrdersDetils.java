package com.dicka.springboot.demointegratedangular.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders_detils",
    catalog = "spring_boot")
public class OrdersDetils implements Serializable{

    //amount = price * quantity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idordersdetils", nullable = false)
    private int idordersdetils;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idorders", nullable = false)
    private Orders orders;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idproduct", nullable = false)
    private Product product;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    public int getIdordersdetils(){
        return idordersdetils;
    }

    public void setIdordersdetils(int idordersdetils){
        this.idordersdetils = idordersdetils;
    }

    public Orders getOrders(){
        return orders;
    }

    public void setOrders(Orders orders){
        this.orders = orders;
    }

    public Product getProduct(){
        return product;
    }

    public void setProduct(Product product){
        this.product = product;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
