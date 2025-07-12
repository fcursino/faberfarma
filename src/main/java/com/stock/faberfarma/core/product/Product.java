package com.stock.faberfarma.core.product;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private Long id;

  @Column(unique = true, nullable = false)
  private String skuCode;

  private String name;
  private String description;
  private Double price;
  private String unitOfMeasure;
  private String defaultSupplier;

  public Product(Long id, String skuCode, String name, String description, String unitOfMeasure, Double price, String defaultSupplier) {
    this.id = id;
    this.skuCode = skuCode;
    this.name = name;
    this.description = description;
    this.unitOfMeasure = unitOfMeasure;
    this.price = price;
    this.defaultSupplier = defaultSupplier;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSkuCode() {
    return skuCode;
  }

  public void setSkuCode(String skuCode) {
    this.skuCode = skuCode;
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

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public String getDefaultSupplier() {
    return defaultSupplier;
  }

  public void setDefaultSupplier(String defaultSupplier) {
    this.defaultSupplier = defaultSupplier;
  }
}
