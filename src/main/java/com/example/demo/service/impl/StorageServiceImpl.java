package com.example.demo.service.impl;

import com.example.demo.entity.Storage;
import com.example.demo.repo.StorageRepo;
import com.example.demo.service.StorageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {

    private StorageRepo repo;

    public StorageServiceImpl(StorageRepo repo){
        this.repo = repo;
    }

    @Override
    public List<Storage> getAll() {
        return repo.findAll();
    }

    @Override
    public Storage getById(String id) {
        return repo.findById(id).get();
    }

    @Override
    public Storage save(Storage storage) {
        Storage storage1 = new Storage();
        storage1.setId(storage.getId());
        storage1.setName(storage.getName());
        storage1.setAddr(storage.getAddr());
        storage1.setId_bra(storage.getId_bra());
        return repo.save(storage1);
    }

    @Override
    public Storage update(Storage storage) {
        Storage storage1 = repo.findById(storage.getId()).get();
        storage1.setId(storage.getId());
        storage1.setName(storage.getName());
        storage1.setAddr(storage.getAddr());
        storage1.setId_bra(storage.getId_bra());
        return repo.save(storage1);
    }

    @Override
    public void delete(String id) {
        repo.deleteById(id);
    }
}
