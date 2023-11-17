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
@Table(name = "STORAGE")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sto;

    private String name_sto;

    private String addr;

    private int id_bra;

    @OneToMany(mappedBy = "storage")
    private List<ReceiptNote> receiptNotes;
}
