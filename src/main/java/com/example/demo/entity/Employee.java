package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emp")
    private int id_emp;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "age")
    private int age;

    @Column(name = "addr")
    private String addr;

    @Column(name = "sal")
    private double sal;

    @Column(name = "id_bra")
    private int id_bra;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "employee")
    private List<ReceiptNote> receiptNotes;

}
