package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cus")
    private int id_cus;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "addr")
    private String addr;

    @Column(name = "num")
    private String num;

    @Column(name = "id_bra")
    private int id_bra;
}
