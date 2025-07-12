package com.stock.faberfarma.core.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

  @Autowired
  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
    this.productRepository = productRepository;
    this.productMapper = productMapper;
  }

  public Product createProduct(ProductDTO productDTO) {
    Product product = productMapper.toEntity(productDTO);
    return productRepository.save(product);
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Optional<Product> getProductById(Long id) {
    return productRepository.findById(id);
  }

  public Product updateProduct(Long id, ProductDTO productDetailsDTO) {
    Product productDetails = productMapper.toEntity(productDetailsDTO);
    Optional<Product> optionalProduct = productRepository.findById(id);
    if (optionalProduct.isPresent()) {
      Product existingProduct = optionalProduct.get();
      existingProduct.setName(productDetails.getName());
      existingProduct.setDescription(productDetails.getDescription());
      existingProduct.setPrice(productDetails.getPrice());
      existingProduct.setDefaultSupplier(productDetails.getDefaultSupplier());
      existingProduct.setUnitOfMeasure(productDetails.getUnitOfMeasure());
      return productRepository.save(existingProduct);
    } else {
      // Ou lance uma exceção, ou retorne null/Optional.empty()
      return null; // Exemplo simplificado
    }
  }

  public boolean deleteProduct(Long id) {
    if (productRepository.existsById(id)) {
      productRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }
}
