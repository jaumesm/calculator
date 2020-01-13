package com.camaiot.calculator.price;

import com.camaiot.calculator.web.model.PriceRequest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PricingImplTest {

    private final PricingImpl pricing = new PricingImpl();

    @Test
    void calculateTotalAmountForBALState() {
        PriceRequest priceRequest = new PriceRequest("book", new BigDecimal("11.25"), 2, "BAL");
        /* expected = (itemPrice * numberOfItems) * (1 + (stateTaxPercentage / 100)) */
        BigDecimal expected = new BigDecimal("26.6175");
        BigDecimal actual = pricing
            .calculateTotalAmount(
                priceRequest.getItemDescription(),
                priceRequest.getItemPrice(),
                priceRequest.getNumberOfItems(),
                priceRequest.getState()
            );
        assertEquals(expected, actual);
    }

    @Test
    void calculateTotalAmountForCANState() {
        PriceRequest priceRequest = new PriceRequest("book", new BigDecimal("11.25"), 2, "CAN");
        /* expected = (itemPrice * numberOfItems) * (1 + (stateTaxPercentage / 100)) */
        BigDecimal expected = new BigDecimal("23.5575");
        BigDecimal actual = pricing
            .calculateTotalAmount(
                priceRequest.getItemDescription(),
                priceRequest.getItemPrice(),
                priceRequest.getNumberOfItems(),
                priceRequest.getState()
            );
        assertEquals(expected, actual);
    }

    @Test
    void calculateTotalAmountForCYMState() {
        PriceRequest priceRequest = new PriceRequest("book", new BigDecimal("11.25"), 2, "CYM");
        /* expected = (itemPrice * numberOfItems) * (1 + (stateTaxPercentage / 100)) */
        BigDecimal expected = new BigDecimal("24.3225");
        BigDecimal actual = pricing
            .calculateTotalAmount(
                priceRequest.getItemDescription(),
                priceRequest.getItemPrice(),
                priceRequest.getNumberOfItems(),
                priceRequest.getState()
            );
        assertEquals(expected, actual);
    }

    @Test
    void calculateTotalAmountForTERState() {
        PriceRequest priceRequest = new PriceRequest("book", new BigDecimal("11.25"), 2, "TER");
        /* expected = (itemPrice * numberOfItems) * (1 + (stateTaxPercentage / 100)) */
        BigDecimal expected = new BigDecimal("22.6125");
        BigDecimal actual = pricing
            .calculateTotalAmount(
                priceRequest.getItemDescription(),
                priceRequest.getItemPrice(),
                priceRequest.getNumberOfItems(),
                priceRequest.getState()
            );
        assertEquals(expected, actual);
    }

    @Test
    void calculateTotalAmountForRESState() {
        PriceRequest priceRequest = new PriceRequest("book", new BigDecimal("11.25"), 2, "RES");
        /* expected = (itemPrice * numberOfItems) * (1 + (stateTaxPercentage / 100)) */
        BigDecimal expected = new BigDecimal("27.3375");
        BigDecimal actual = pricing
            .calculateTotalAmount(
                priceRequest.getItemDescription(),
                priceRequest.getItemPrice(),
                priceRequest.getNumberOfItems(),
                priceRequest.getState()
            );
        assertEquals(expected, actual);
    }

}
