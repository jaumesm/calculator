package com.camaiot.calculator.tax;

import com.camaiot.calculator.exception.BadRequestException;
import com.camaiot.calculator.repository.StateTaxRepository;
import com.camaiot.calculator.repository.entity.StateTax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StateTaxService {

    private StateTaxRepository stateTaxRepository;

    @Autowired
    public StateTaxService(StateTaxRepository stateTaxRepository) {
        this.stateTaxRepository = stateTaxRepository;
    }

    public BigDecimal getTaxPercentage(String state) {
        StateTax stateTax = stateTaxRepository.findByState(state.toUpperCase());
        if (stateTax != null) {
            return stateTax.getTaxPercentage();
        } else {
            throw new BadRequestException("state: invalid value");
        }
    }
}
