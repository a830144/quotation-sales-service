package com.mysap.sd.quotation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysap.sd.quotation.entity.QuotationHeader;
import com.mysap.sd.quotation.repository.QuotationHeaderRepository;

@Service
public class QuotationHeaderService {

    @Autowired
    private QuotationHeaderRepository repository;

    public QuotationHeader create(QuotationHeader header) {
        return repository.save(header);
    }

    public Optional<QuotationHeader> getById(Long id) {
        return repository.findById(id);
    }

    public List<QuotationHeader> getAll() {
        return repository.findAll();
    }

    public QuotationHeader update(Long id, QuotationHeader newHeader) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setCustomerId(newHeader.getCustomerId());
                    existing.setQuoteDate(newHeader.getQuoteDate());
                    existing.setValidUntil(newHeader.getValidUntil());
                    return repository.save(existing);
                }).orElseThrow(() -> new RuntimeException("Quotation not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
