package com.example.demo.controller;

import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping("/product")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/hello")
    public String hello() {
        return "index";
    }


    // Hiển thị danh sách sản phẩm và form thêm sản phẩm
    @GetMapping
    public String hienThiDanhSachSanPham(Model model) {
        log.info("Product : {}" ,productService.layTatCaSanPham());
        model.addAttribute("products", productService.layTatCaSanPham());
        model.addAttribute("productForm", new ProductEntity());
        return "list"; // Trỏ tới trang product/list (trang Thymeleaf bạn đã tạo)
    }

    // Thêm sản phẩm mới
    @PostMapping("/add")
    public String themSanPham(@ModelAttribute ProductEntity product, Model model) {
        productService.taoSanPham(product);
        return "redirect:/product"; // Sau khi thêm xong, chuyển về trang danh sách sản phẩm
    }

    // Cập nhật sản phẩm
    @PostMapping("/update/{id}")
    public String capNhatSanPham(@PathVariable("id") String id, @ModelAttribute ProductEntity product, Model model) {
        productService.capNhatSanPham(id, product);
        return "redirect:/product"; // Sau khi cập nhật xong, chuyển về trang danh sách sản phẩm
    }

    // Xóa sản phẩm
    @PostMapping("/delete/{id}")
    public String xoaSanPham(@PathVariable("id") String id) {
        productService.xoaSanPham(id);
        return "redirect:/product"; // Sau khi xóa xong, chuyển về trang danh sách sản phẩm
    }
}
