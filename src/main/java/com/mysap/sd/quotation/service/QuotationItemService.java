package com.mysap.sd.quotation.service;

import com.mysap.sd.quotation.entity.QuotationHeader;
import com.mysap.sd.quotation.entity.QuotationItem;
import com.mysap.sd.quotation.repository.QuotationHeaderRepository;
import com.mysap.sd.quotation.repository.QuotationItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuotationItemService {

    @Autowired
    private QuotationItemRepository itemRepo;

    @Autowired
    private QuotationHeaderRepository headerRepo;

    public List<QuotationItem> getItemsByQuoteId(Long quoteId) {
        return itemRepo.findByQuotation_Id(quoteId);
    }

    public QuotationItem createItem(Long quoteId, QuotationItem item) {
        QuotationHeader header = headerRepo.findById(quoteId)
                .orElseThrow(() -> new IllegalArgumentException("Quote not found"));

        item.setQuotationHeader(header);
        return itemRepo.save(item);
    }

    public QuotationItem updateItem(Long id, QuotationItem updatedItem) {
        Optional<QuotationItem> existing = itemRepo.findById(id);
        if (existing.isEmpty()) {
            throw new IllegalArgumentException("Item not found");
        }

        QuotationItem item = existing.get();
        item.setProductId(updatedItem.getProductId());
        item.setQuantity(updatedItem.getQuantity());
        item.setSuggestedPrice(updatedItem.getSuggestedPrice());
        item.setFinalPrice(updatedItem.getFinalPrice());
        item.setCurrency(updatedItem.getCurrency());
        return itemRepo.save(item);
    }

    public void deleteItem(Long id) {
        itemRepo.deleteById(id);
    }

    public Optional<QuotationItem> getById(Long id) {
        return itemRepo.findById(id);
    }
}
