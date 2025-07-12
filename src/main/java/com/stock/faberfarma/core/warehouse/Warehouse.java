package com.stock.faberfarma.core.warehouse;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "warehouses")
public class Warehouse {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private WarehouseType type;
  private String address;

  public Warehouse(Long id, WarehouseType type, String address) {
    this.id = id;
    this.type = type;
    this.address = address;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public WarehouseType getType() {
    return type;
  }

  public void setType(WarehouseType type) {
    this.type = type;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
