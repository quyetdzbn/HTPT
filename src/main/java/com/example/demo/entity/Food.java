package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FOOD")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foo")
    private int id_foo;

    @Column(name = "name_foo")
    private String name_foo;

    @Column(name = "price")
    private double price;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "in_stock")
    private int inStock;
}
