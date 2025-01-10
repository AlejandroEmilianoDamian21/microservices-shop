package com.tikidev.products_service.models.dtos;

import lombok.Builder;

@Builder
public class ProductRequest {
    private String sku;
    private String name;
    private String description;
    private double price;
    private Boolean status;

    public ProductRequest() {
    }

    public ProductRequest(String sku, String name, String description, double price, Boolean status) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
