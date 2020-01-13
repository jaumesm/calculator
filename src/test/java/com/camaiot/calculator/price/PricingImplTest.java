package com.camaiot.calculator.price;

import com.camaiot.calculator.tax.StateTaxService;
import com.camaiot.calculator.web.model.PriceRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PricingImplTest {

    @Mock
    private StateTaxService stateTaxService;

    private PricingImpl pricing;

    @BeforeEach
    void setUp() {
        pricing = new PricingImpl(stateTaxService);
    }

    @Test
    void calculateTotalAmountForBALState() {
        when(stateTaxService.getTaxPercentage("BAL")).thenReturn(new BigDecimal("18.3"));
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
        when(stateTaxService.getTaxPercentage("CAN")).thenReturn(new BigDecimal("4.7"));
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
        when(stateTaxService.getTaxPercentage("CYM")).thenReturn(new BigDecimal("8.1"));
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
        when(stateTaxService.getTaxPercentage("TER")).thenReturn(new BigDecimal("0.5"));
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
        when(stateTaxService.getTaxPercentage("RES")).thenReturn(new BigDecimal("21.5"));
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
