package com.stock.faberfarma.core.supplier;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "suppliers")
public class Supplier {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String cnpj;
  private String contact;
  private String address;
  private Integer daysToDeliver;

  public Supplier(Long id, String cnpj, String contact, String address, Integer daysToDeliver) {
    this.id = id;
    this.cnpj = cnpj;
    this.contact = contact;
    this.address = address;
    this.daysToDeliver = daysToDeliver;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getDaysToDeliver() {
    return daysToDeliver;
  }

  public void setDaysToDeliver(Integer daysToDeliver) {
    this.daysToDeliver = daysToDeliver;
  }
}
