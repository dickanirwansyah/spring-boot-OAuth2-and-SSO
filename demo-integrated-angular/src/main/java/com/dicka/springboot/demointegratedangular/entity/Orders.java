package com.dicka.springboot.demointegratedangular.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "orders",
        catalog = "spring_boot")
public class Orders implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorders", nullable = false)
    private Long idorders;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "orderdate", nullable = false)
    private Date orderdate;

    @Column(name = "total", nullable = false)
    private int total;

    @Email
    @Column(name = "customer_email", nullable = false)
    private String customerEmail;

    @Column(name = "customer_phone", nullable = false)
    private String customerPhone;

    @Column(name = "customer_address", nullable = false)
    private String customerAddress;

    @JsonIgnore
    @OneToMany(mappedBy = "orders")
    private List<OrdersDetils> ordersDetils;

    public List<OrdersDetils> getOrdersDetils(){
        return ordersDetils;
    }

    public void setOrdersDetils(List<OrdersDetils> ordersDetils){
        this.ordersDetils = ordersDetils;
    }

    public Long getIdorders(){
        return idorders;
    }

    public void setIdorders(Long idorders){
        this.idorders = idorders;
    }

    public Date getOrderdate(){
        return orderdate;
    }

    public void setOrderdate(Date orderdate){
        this.orderdate = orderdate;
    }

    public int getTotal(){
        return total;
    }

    public void setTotal(int total){
        this.total = total;
    }

    public String getCustomerEmail(){
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail){
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone(){
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone){
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress(){
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress){
        this.customerAddress = customerAddress;
    }
}
