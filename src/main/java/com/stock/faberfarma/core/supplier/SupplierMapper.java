package com.stock.faberfarma.core.supplier;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

  @Mapping(target = "id", ignore = true)
  Supplier toEntity(SupplierDTO supplierDTO);
  SupplierDTO toDto(Supplier supplier);
}