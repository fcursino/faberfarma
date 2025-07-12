package com.stock.faberfarma.core.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {
  @Autowired
  private WarehouseService warehouseService;

  @PostMapping
  public ResponseEntity<Warehouse> createWarehouse(@RequestBody WarehouseDTO warehouse) {
    Warehouse createdWarehouse = warehouseService.createWarehouse(warehouse);
    return new ResponseEntity<>(createdWarehouse, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Warehouse>> getAllWarehouses() {
    List<Warehouse> warehouses = warehouseService.getAllWarehouses();
    return new ResponseEntity<>(warehouses, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long id) {
    Optional<Warehouse> warehouse = warehouseService.getWarehouseById(id);
    return warehouse.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long id, @RequestBody WarehouseDTO warehouseDetailsDTO) {
    Warehouse updatedWarehouse = warehouseService.updateWarehouse(id, warehouseDetailsDTO);
    if (updatedWarehouse != null) {
      return new ResponseEntity<>(updatedWarehouse, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteWarehouse(@PathVariable Long id) {
    boolean deleted = warehouseService.deleteWarehouse(id);
    if (deleted) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
