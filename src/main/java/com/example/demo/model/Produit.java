package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  Long Id;
    private String name;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Produit Id(Long Id) {
        this.Id = Id;
        return this;
    }

    public Produit name(String name) {
        this.name = name;
        return this;
    }
}
