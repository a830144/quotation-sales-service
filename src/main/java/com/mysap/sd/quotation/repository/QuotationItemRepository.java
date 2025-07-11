package com.mysap.sd.quotation.repository;

import com.mysap.sd.quotation.entity.QuotationItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotationItemRepository extends JpaRepository<QuotationItem, Long> {
    List<QuotationItem> findByQuotationHeader_Id(Long quotationId);
}