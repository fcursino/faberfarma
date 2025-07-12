package com.stock.faberfarma.core.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
  @Autowired
  private SupplierService supplierService;

  @PostMapping
  public ResponseEntity<Supplier> createSupplier(@RequestBody SupplierDTO supplier) {
    Supplier createdSupplier = supplierService.createSupplier(supplier);
    return new ResponseEntity<>(createdSupplier, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Supplier>> getAllSuppliers() {
    List<Supplier> suppliers = supplierService.getAllSuppliers();
    return new ResponseEntity<>(suppliers, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
    Optional<Supplier> supplier = supplierService.getSupplierById(id);
    return supplier.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody SupplierDTO supplierDetailsDTO) {
    Supplier updatedSupplier = supplierService.updateSupplier(id, supplierDetailsDTO);
    if (updatedSupplier != null) {
      return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
    boolean deleted = supplierService.deleteSupplier(id);
    if (deleted) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
