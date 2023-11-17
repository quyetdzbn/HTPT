package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STORAGE")
public class Storage {
    @Id
    @Column(name = "id_sto")
    private String id;

    @Column(name = "name_sto")
    private String name;

    @Column(name = "addr")
    private String addr;

    @Column(name = "id_bra")
    private int id_bra;
}
