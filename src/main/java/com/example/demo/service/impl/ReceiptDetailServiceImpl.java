package com.example.demo.service.impl;

import com.example.demo.entity.ReceiptDetail;
import com.example.demo.repo.ReceiptDetailRepo;
import com.example.demo.service.ReceiptDetailService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReceiptDetailServiceImpl implements ReceiptDetailService {

    private ReceiptDetailRepo repo;

    public ReceiptDetailServiceImpl(ReceiptDetailRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<ReceiptDetail> getAll() {
        return repo.findAll();
    }

    @Override
    public ReceiptDetail getById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public ReceiptDetail save(ReceiptDetail receiptDetail) {
        ReceiptDetail receiptDetail1 = new ReceiptDetail();
        receiptDetail1.setId_foo(receiptDetail.getId_foo());
        receiptDetail1.setAmount(receiptDetail.getAmount());
        receiptDetail1.setPrice(receiptDetail.getPrice());
        return repo.save(receiptDetail1);
    }

    @Override
    public ReceiptDetail update(ReceiptDetail receiptDetail) {
        ReceiptDetail receiptDetail1 = null;
        try {
            receiptDetail1 = repo.findById(receiptDetail.getId_rec()).get();
            receiptDetail1.setId_foo(receiptDetail.getId_foo());
            receiptDetail1.setAmount(receiptDetail.getAmount());
            receiptDetail1.setPrice(receiptDetail.getPrice());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return repo.save(receiptDetail1);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
