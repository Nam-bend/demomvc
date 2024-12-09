package com.example.demo.service.impl;

import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> layTatCaSanPham() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductEntity> laySanPhamTheoId(String id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductEntity taoSanPham(ProductEntity product) {
        return productRepository.save(product);
    }

    @Override
    public ProductEntity capNhatSanPham(String id, ProductEntity product) {
        if (productRepository.existsById(id)) {
            return productRepository.save(product);
        }
        return null; // Nếu không tìm thấy sản phẩm với id, trả về null
    }

    @Override
    public void xoaSanPham(String id) {
        productRepository.deleteById(id);
    }
}
