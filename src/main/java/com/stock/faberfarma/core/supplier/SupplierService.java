package com.stock.faberfarma.core.supplier;

import com.stock.faberfarma.core.supplier.Supplier;
import com.stock.faberfarma.core.supplier.SupplierDTO;
import com.stock.faberfarma.core.supplier.SupplierMapper;
import com.stock.faberfarma.core.supplier.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
  @Autowired
  private final SupplierRepository supplierRepository;
  private final SupplierMapper supplierMapper;

  public SupplierService(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {
    this.supplierRepository = supplierRepository;
    this.supplierMapper = supplierMapper;
  }

  public Supplier createSupplier(SupplierDTO supplierDTO) {
    Supplier supplier = supplierMapper.toEntity(supplierDTO);
    return supplierRepository.save(supplier);
  }

  public List<Supplier> getAllSuppliers() {
    return supplierRepository.findAll();
  }

  public Optional<Supplier> getSupplierById(Long id) {
    return supplierRepository.findById(id);
  }

  public Supplier updateSupplier(Long id, SupplierDTO productDetailsDTO) {
    Supplier productDetails = supplierMapper.toEntity(productDetailsDTO);
    Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
    if (optionalSupplier.isPresent()) {
      Supplier existingSupplier = optionalSupplier.get();
      existingSupplier.setCnpj(productDetails.getCnpj());
      existingSupplier.setContact(productDetails.getContact());
      existingSupplier.setDaysToDeliver(productDetails.getDaysToDeliver());
      existingSupplier.setAddress(productDetails.getAddress());
      return supplierRepository.save(existingSupplier);
    } else {
      // Ou lance uma exceção, ou retorne null/Optional.empty()
      return null; // Exemplo simplificado
    }
  }

  public boolean deleteSupplier(Long id) {
    if (supplierRepository.existsById(id)) {
      supplierRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }
}
