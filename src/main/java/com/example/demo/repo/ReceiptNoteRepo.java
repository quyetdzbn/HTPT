package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ReceiptNote;

public interface ReceiptNoteRepo extends JpaRepository<ReceiptNote, Integer> {

}
