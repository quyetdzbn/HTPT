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
    @Column(name = "id_foo")
    private String id;

    @Column(name = "name_foo")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "in_stock")
    private int inStock;
}
