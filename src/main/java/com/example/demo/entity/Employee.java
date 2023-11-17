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
    private int id_emp;

    private String fullname;

    private int age;

    private String addr;

    private double sal;

    private int id_bra;

    private String username;

    private String password;

    @OneToMany(mappedBy = "employee")
    private List<ReceiptNote> receiptNotes;

}
