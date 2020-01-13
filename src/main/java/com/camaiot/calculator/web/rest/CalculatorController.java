package com.camaiot.calculator.web.rest;

import com.camaiot.calculator.price.Pricing;
import com.camaiot.calculator.web.model.PriceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private Pricing pricing;

    @Autowired
    public CalculatorController(Pricing pricing) {
        this.pricing = pricing;
    }

    @GetMapping("/price")
    public BigDecimal calculateTotalAmount(PriceRequest priceRequest) {
        return pricing.calculateTotalAmount(
            priceRequest.getItemDescription(),
            priceRequest.getItemPrice(),
            priceRequest.getNumberOfItems(),
            priceRequest.getState()
        );
    }

}
