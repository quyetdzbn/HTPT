package com.example.demo.service;

import com.example.demo.entity.ReceiptNote;

import java.util.List;

public interface ReceiptNoteService {
    List<ReceiptNote> getAll();

    ReceiptNote getById(Integer id);

    ReceiptNote save(ReceiptNote receiptNote);

    ReceiptNote update(ReceiptNote receiptNote);

    void delete(Integer id);
}