package com.dicka.springboot.demointegratedangular.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "product",
        catalog = "spring_boot")
public class Product implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idproduct;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "valid")
    private boolean valid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcategory", nullable = false)
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<OrdersDetils> ordersDetils;

    public String getIdproduct(){
        return idproduct;
    }

    public void setIdproduct(String idproduct){
        this.idproduct = idproduct;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public boolean isValid(){
        return valid;
    }

    public void setValid(boolean valid){
        this.valid = valid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category){
        this.category=category;
    }

    public List<OrdersDetils> getOrdersDetils(){
        return ordersDetils;
    }

    public void setOrdersDetils(List<OrdersDetils> ordersDetils){
        this.ordersDetils = ordersDetils;
    }
}
