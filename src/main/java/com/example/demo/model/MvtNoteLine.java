package com.example.demo.model;

import javax.persistence.*;

@Entity
public class MvtNoteLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String line;
    @Column(name = "pro_id")
    private Long proId;

    @ManyToOne
    @JoinColumn(name="pro_id", insertable = false, updatable = false)
    private Produit produit;

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public MvtNoteLine id(Long id) {
        this.id = id;
        return this;
    }

    public MvtNoteLine line(String line) {
        this.line = line;
        return this;
    }

    public MvtNoteLine proId(Long proId) {
        this.proId = proId;
        return this;
    }

    public MvtNoteLine produit(Produit produit) {
        this.produit = produit;
        return this;
    }
}
