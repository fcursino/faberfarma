package com.stock.faberfarma.core.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
  @Autowired
  private final WarehouseRepository warehouseRepository;
  private final WarehouseMapper warehouseMapper;

  public WarehouseService(WarehouseRepository warehouseRepository, WarehouseMapper warehouseMapper) {
    this.warehouseRepository = warehouseRepository;
    this.warehouseMapper = warehouseMapper;
  }

  public Warehouse createWarehouse(WarehouseDTO warehouseDTO) {
    Warehouse warehouse = warehouseMapper.toEntity(warehouseDTO);
    return warehouseRepository.save(warehouse);
  }

  public List<Warehouse> getAllWarehouses() {
    return warehouseRepository.findAll();
  }

  public Optional<Warehouse> getWarehouseById(Long id) {
    return warehouseRepository.findById(id);
  }

  public Warehouse updateWarehouse(Long id, WarehouseDTO productDetailsDTO) {
    Warehouse productDetails = warehouseMapper.toEntity(productDetailsDTO);
    Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
    if (optionalWarehouse.isPresent()) {
      Warehouse existingWarehouse = optionalWarehouse.get();
      existingWarehouse.setType(productDetails.getType());
      existingWarehouse.setAddress(productDetails.getAddress());
      return warehouseRepository.save(existingWarehouse);
    } else {
      // Ou lance uma exceção, ou retorne null/Optional.empty()
      return null; // Exemplo simplificado
    }
  }

  public boolean deleteWarehouse(Long id) {
    if (warehouseRepository.existsById(id)) {
      warehouseRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }
}
