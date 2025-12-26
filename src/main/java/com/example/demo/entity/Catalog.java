package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "catalog")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String crop;

    private String fertilizer;

    public Catalog() {
    }

    public Catalog(Long id, String crop, String fertilizer) {
        this.id = id;
        this.crop = crop;
        this.fertilizer = fertilizer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public String getFertilizer() {
        return fertilizer;
    }

    public void setFertilizer(String fertilizer) {
        this.fertilizer = fertilizer;
    }
}
