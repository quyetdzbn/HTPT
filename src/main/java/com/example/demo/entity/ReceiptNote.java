package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RECEIPT_NOTE")
public class ReceiptNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rec;

    private Date date_time;

    private String source;

    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "id_emp")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_sto")
    private Storage storage;
}
