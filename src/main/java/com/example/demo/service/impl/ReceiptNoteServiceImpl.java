package com.example.demo.service.impl;

import com.example.demo.entity.ReceiptNote;
import com.example.demo.repo.ReceiptNoteRepo;
import com.example.demo.service.ReceiptNoteService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReceiptNoteServiceImpl implements ReceiptNoteService {

    private ReceiptNoteRepo repo;

    public ReceiptNoteServiceImpl(ReceiptNoteRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<ReceiptNote> getAll() {
        return repo.findAll();
    }

    @Override
    public ReceiptNote getById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public ReceiptNote save(ReceiptNote receiptNote) {
        ReceiptNote receiptNote1 = new ReceiptNote();
        receiptNote1.setDate_time(receiptNote.getDate_time());
        receiptNote1.setSource(receiptNote.getSource());
        receiptNote1.setTotalPrice(receiptNote.getTotalPrice());
        receiptNote1.setId_emp(receiptNote.getId_emp());
        receiptNote1.setId_sto(receiptNote.getId_sto());

        return repo.save(receiptNote1);
    }

    @Override
    public ReceiptNote update(ReceiptNote receiptNote) {
        ReceiptNote receiptNote1 = null;
        try {
            receiptNote1 = repo.findById(receiptNote.getId_rec()).get();
            receiptNote1.setDate_time(receiptNote.getDate_time());
            receiptNote1.setSource(receiptNote.getSource());
            receiptNote1.setTotalPrice(receiptNote.getTotalPrice());
            receiptNote1.setId_emp(receiptNote.getId_emp());
            receiptNote1.setId_sto(receiptNote.getId_sto());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return repo.save(receiptNote1);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
