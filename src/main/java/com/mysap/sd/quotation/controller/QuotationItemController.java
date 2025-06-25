package com.mysap.sd.quotation.controller;

import com.mysap.sd.quotation.entity.QuotationItem;
import com.mysap.sd.quotation.service.QuotationItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotation/items")
public class QuotationItemController {

    @Autowired
    private QuotationItemService service;

    @GetMapping("/quote/{quoteId}")
    public List<QuotationItem> getItemsByQuoteId(@PathVariable Long quoteId) {
        return service.getItemsByQuoteId(quoteId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuotationItem> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "*") // or specific origin
    @PostMapping("/quote/{quoteId}")
    public ResponseEntity<QuotationItem> create(@PathVariable Long quoteId,
                                                @RequestBody QuotationItem item) {
        return ResponseEntity.ok(service.createItem(quoteId, item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuotationItem> update(@PathVariable Long id,
                                                @RequestBody QuotationItem item) {
        return ResponseEntity.ok(service.updateItem(id, item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
