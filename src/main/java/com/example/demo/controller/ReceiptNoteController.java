package com.example.demo.controller;

import com.example.demo.entity.ReceiptNote;
import com.example.demo.service.ReceiptNoteService;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class ReceiptNoteController {
    private ReceiptNoteService service;

    public ReceiptNoteController(ReceiptNoteService service) {
        this.service = service;
    }

    @GetMapping("/receiptNotes")
    public String receiptNotes(Model model, Principal principal) {
        List<ReceiptNote> receiptNotes = service.getAll();
        model.addAttribute("receiptNoteList", receiptNotes);
        model.addAttribute("size", receiptNotes.size());
        model.addAttribute("title", "ReceiptNote");
        model.addAttribute("receiptNote", new ReceiptNote());
        return "receiptNotes";
    }

    @RequestMapping(value = "/receiptNotes/findById", method = { RequestMethod.PUT, RequestMethod.GET })
    @ResponseBody
    public ReceiptNote getById(Integer id) {
        return service.getById(id);
    }

    @GetMapping("/update-receiptNote")
    public String update(ReceiptNote receiptNote, RedirectAttributes attributes) {
        try {
            service.save(receiptNote);
            attributes.addFlashAttribute("success", "Updated successfully!");
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to update because duplicate name");
        } catch (Exception e) {
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Error server");
        }
        return "redirect:/receiptNotes";
    }

    @PostMapping("/add-receiptNote")
    public String add(@ModelAttribute("receiptNote") ReceiptNote receiptNote, RedirectAttributes attributes) {
        try {
            service.save(receiptNote);
            attributes.addFlashAttribute("success", "Added successfully!");
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to add because duplicate name!");
        } catch (Exception e) {
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Error server!");
        }
        return "redirect:/receiptNotes";
    }
}