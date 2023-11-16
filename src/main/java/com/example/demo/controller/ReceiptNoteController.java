package com.example.demo.controller;

import com.example.demo.entity.ReceiptNote;
import com.example.demo.service.ReceiptNoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ReceiptNoteController {
    private ReceiptNoteService service;

    public ReceiptNoteController(ReceiptNoteService service) {
        this.service = service;
    }
}