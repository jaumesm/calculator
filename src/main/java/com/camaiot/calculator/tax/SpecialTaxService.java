package com.camaiot.calculator.tax;

import com.camaiot.calculator.repository.SpecialTaxRepository;
import com.camaiot.calculator.repository.entity.SpecialTax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SpecialTaxService {

    SpecialTaxRepository specialTaxRepository;

    @Autowired
    public SpecialTaxService(SpecialTaxRepository specialTaxRepository) {
        this.specialTaxRepository = specialTaxRepository;
    }

    public BigDecimal getTaxPercentage(String itemDescription) {
        SpecialTax specialTax = specialTaxRepository.findByItemDescription(itemDescription.toLowerCase());
        if (specialTax != null) {
            return specialTax.getTaxPercentage();
        }
        return null;
    }
}
