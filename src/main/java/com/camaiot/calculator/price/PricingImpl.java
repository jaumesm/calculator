package com.camaiot.calculator.price;

import com.camaiot.calculator.tax.StateTaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PricingImpl implements Pricing {

    private final BigDecimal ONE_HUNDRED = new BigDecimal("100");

    private StateTaxService stateTaxService;

    @Autowired
    public PricingImpl(StateTaxService stateTaxService) {
        this.stateTaxService = stateTaxService;
    }

    @Override
    public BigDecimal calculateTotalAmount(String itemDescription, BigDecimal itemPrice, Integer numberOfItems, String state) {
        BigDecimal stateTaxPercentage = stateTaxService.getTaxPercentage(state);
        /* total = (itemPrice * numberOfItems) * (1 + (stateTaxPercentage / 100)) */
        BigDecimal stateTaxIncrement = BigDecimal.ONE.add(stateTaxPercentage.divide(ONE_HUNDRED));
        BigDecimal total = itemPrice.multiply(BigDecimal.valueOf(numberOfItems)).multiply(stateTaxIncrement);
        return total.stripTrailingZeros();
    }

}
