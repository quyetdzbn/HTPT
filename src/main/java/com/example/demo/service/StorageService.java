package com.example.demo.service;

import com.example.demo.entity.Storage;

import java.util.List;

public interface StorageService {
    List<Storage> getAll();
    Storage getById(String id);
    Storage save(Storage storage);
    Storage update(Storage storage);
    void delete(String id);
}
