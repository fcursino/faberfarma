package com.stock.faberfarma.core.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  @Mapping(target = "id", ignore = true)
  Product toEntity(ProductDTO productDTO);
  ProductDTO toDto(Product product);
}