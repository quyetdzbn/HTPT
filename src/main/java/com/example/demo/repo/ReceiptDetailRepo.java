package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ReceiptDetail;

public interface ReceiptDetailRepo extends JpaRepository<ReceiptDetail, Integer> {

}
