package com.stock.faberfarma.core.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
  private String skuCode;
  private String name;
  private String description;
  private Double price;
  private String unitOfMeasure;
  private String defaultSupplier;
}
