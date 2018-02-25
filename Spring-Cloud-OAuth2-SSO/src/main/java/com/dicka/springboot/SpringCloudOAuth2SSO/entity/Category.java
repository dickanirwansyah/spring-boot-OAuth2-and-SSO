package com.dicka.springboot.SpringCloudOAuth2SSO.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categorys",
        catalog = "spring_boot")
public class Category implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategory")
    private int idcategory;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "valide", nullable = false)
    private boolean valide;

    public int getIdcategory(){
        return idcategory;
    }

    public void setIdcategory(int idcategory){
        this.idcategory = idcategory;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public boolean isValide(){
        return valide;
    }

    public void setValide(boolean valide){
        this.valide = valide;
    }
}
