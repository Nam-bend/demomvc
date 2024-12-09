package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "san_pham")
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;
    private String ten ;
    @Column(name = "gia_san_pham")
    private String giaSanPham ;
    @Column(name = "mo_ta")
    private String moTa ;
}
