package com.example.demo.service;

import com.example.demo.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    // lay all san pham
    List<ProductEntity> layTatCaSanPham();

    // lay san pham theo id
    Optional<ProductEntity> laySanPhamTheoId(String id);

    //them san pham moi
    ProductEntity taoSanPham(ProductEntity product);

    // cap nhat san pham theo id
    ProductEntity capNhatSanPham(String id, ProductEntity product);

    // delete
    void xoaSanPham(String id);
}
