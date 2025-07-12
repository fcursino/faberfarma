package com.stock.faberfarma.core.warehouse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WarehouseMapper {

  @Mapping(target = "id", ignore = true)
  Warehouse toEntity(WarehouseDTO warehouseDTO);
  WarehouseDTO toDto(Warehouse warehouse);
}