package com.mysap.sd.quotation.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysap.sd.quotation.entity.QuotationHeader;
import com.mysap.sd.quotation.service.QuotationHeaderService;

@RestController
@RequestMapping("/quotations")
public class QuotationHeaderController {

    @Autowired
    private QuotationHeaderService service;

    @CrossOrigin(origins = "*") // or specific origin
    @PostMapping
    public ResponseEntity<QuotationHeader> create(@RequestBody QuotationHeader header) {
        return ResponseEntity.ok(service.create(header));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuotationHeader> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "*") // or specific origin
    @GetMapping
    public List<QuotationHeader> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuotationHeader> update(@PathVariable Long id, @RequestBody QuotationHeader header) {
        return ResponseEntity.ok(service.update(id, header));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

