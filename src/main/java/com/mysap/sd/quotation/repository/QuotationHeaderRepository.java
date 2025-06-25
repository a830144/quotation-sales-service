package com.mysap.sd.quotation.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mysap.sd.quotation.entity.QuotationHeader;

public interface QuotationHeaderRepository extends JpaRepository<QuotationHeader, Long> {
}

