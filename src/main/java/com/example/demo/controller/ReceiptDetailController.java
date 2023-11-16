package com.example.demo.controller;

import com.example.demo.entity.ReceiptDetail;
import com.example.demo.service.ReceiptDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ReceiptDetailController {
    private ReceiptDetailService service;

    public ReceiptDetailController(ReceiptDetailService service) {
        this.service = service;
    }
}