package com.camaiot.calculator.price;

import com.camaiot.calculator.discount.DiscountService;
import com.camaiot.calculator.tax.SpecialTaxService;
import com.camaiot.calculator.tax.StateTaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PricingImpl implements Pricing {

    private final BigDecimal ONE_HUNDRED = new BigDecimal("100");

    private StateTaxService stateTaxService;
    private SpecialTaxService specialTaxService;
    private DiscountService discountService;

    @Autowired
    public PricingImpl(
        StateTaxService stateTaxService,
        SpecialTaxService specialTaxService,
        DiscountService discountService
    ) {
        this.stateTaxService = stateTaxService;
        this.specialTaxService = specialTaxService;
        this.discountService = discountService;
    }

    @Override
    public BigDecimal calculateTotalAmount(String itemDescription, BigDecimal itemPrice, Integer numberOfItems, String state) {
        // base = (itemPrice * numberOfItems)
        BigDecimal base = itemPrice.multiply(BigDecimal.valueOf(numberOfItems));
        // total = base + stateTaxAmount + specialTaxAmount
        BigDecimal total = base.add(calculateStateTaxAmount(base, state))
                               .add(calculateSpecialTaxAmount(base, itemDescription));
        return applyDiscount(total).stripTrailingZeros();
    }

    private BigDecimal calculateStateTaxAmount(BigDecimal amount, String state) {
        BigDecimal stateTaxPercentage = stateTaxService.getTaxPercentage(state);
        return calculateTaxAmount(amount, stateTaxPercentage);
    }

    private BigDecimal calculateSpecialTaxAmount(BigDecimal amount, String itemDescription) {
        BigDecimal specialTaxPercentage = specialTaxService.getTaxPercentage(itemDescription);
        if (specialTaxPercentage != null) {
            return calculateTaxAmount(amount, specialTaxPercentage);
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal calculateTaxAmount(BigDecimal amount, BigDecimal taxPercentage) {
        // taxAmount = amount * (taxPercentage / 100)
        return amount.multiply(taxPercentage.divide(ONE_HUNDRED));
    }

//    BigDecimal stateTaxPercentage = stateTaxService.getTaxPercentage(state);
//    /* total = (itemPrice * numberOfItems) * (1 + (stateTaxPercentage / 100)) */
//    BigDecimal stateTaxIncrement = BigDecimal.ONE.add(stateTaxPercentage.divide(ONE_HUNDRED));
//    BigDecimal total = itemPrice.multiply(BigDecimal.valueOf(numberOfItems)).multiply(stateTaxIncrement);

    private BigDecimal applyDiscount(BigDecimal amount) {
        BigDecimal discountPercentage = discountService.getDiscount(amount);
        if (discountPercentage != null) {
            // amountWithDiscount = amount * (1 - (discountPercentage / 100))
            return amount.multiply(BigDecimal.ONE.subtract(discountPercentage.divide(ONE_HUNDRED)));
        }
        return amount;
    }

}
