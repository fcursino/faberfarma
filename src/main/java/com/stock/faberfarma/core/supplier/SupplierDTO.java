package com.stock.faberfarma.core.supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {
  private String cnpj;
  private String contact;
  private String address;
  private Integer daysToDeliver;
}
