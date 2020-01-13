package com.camaiot.calculator.price;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PricingImpl implements Pricing {

    @Override
    public BigDecimal calculateTotalAmount(String itemDescription, BigDecimal itemPrice, Integer numberOfItems, String state) {
        // TODO: implement
        return null;
    }

}
