package com.example.demo.service;

import com.example.demo.entity.ReceiptDetail;

import java.util.List;

public interface ReceiptDetailService {
    List<ReceiptDetail> getAll();

    ReceiptDetail getById(Integer id);

    ReceiptDetail save(ReceiptDetail receiptDetail);

    ReceiptDetail update(ReceiptDetail receiptDetail);

    void delete(Integer id);
}