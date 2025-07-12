package com.stock.faberfarma.core.warehouse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseDTO {
  private WarehouseType type;
  private String address;
}
