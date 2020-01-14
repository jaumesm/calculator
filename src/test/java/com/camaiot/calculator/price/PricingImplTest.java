package com.camaiot.calculator.price;

import com.camaiot.calculator.discount.DiscountService;
import com.camaiot.calculator.tax.StateTaxService;
import com.camaiot.calculator.web.model.PriceRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PricingImplTest {

    @Mock
    private StateTaxService stateTaxService;

    @Mock
    private DiscountService discountService;

    private PricingImpl pricing;

    @BeforeEach
    void setUp() {
        pricing = new PricingImpl(stateTaxService, discountService);
    }

    @Test
    void calculateTotalAmountForBALState() {
        when(stateTaxService.getTaxPercentage("BAL")).thenReturn(new BigDecimal("18.3"));
        when(discountService.getDiscount(any())).thenReturn(null);
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
        when(discountService.getDiscount(any())).thenReturn(null);
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
        when(discountService.getDiscount(any())).thenReturn(null);
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
        when(discountService.getDiscount(any())).thenReturn(null);
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
        when(discountService.getDiscount(any())).thenReturn(null);
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

    @Test
    void calculateTotalAmountWith3Discount(){
        when(stateTaxService.getTaxPercentage("RES")).thenReturn(new BigDecimal("21.5"));
        when(discountService.getDiscount(any())).thenReturn(new BigDecimal("3"));
        PriceRequest priceRequest = new PriceRequest("smartphone", new BigDecimal("1000"), 1, "RES");
        /*
        priceWithStateTax = (itemPrice * numberOfItems) * (1 + (stateTaxPercentage / 100))
        expected = (priceWithStateTax) * (1 - (discountPercentage / 100))
         */
        BigDecimal expected = new BigDecimal("1178.55");
        BigDecimal actual = pricing.calculateTotalAmount(
            priceRequest.getItemDescription(),
            priceRequest.getItemPrice(),
            priceRequest.getNumberOfItems(),
            priceRequest.getState()
        );
        assertEquals(expected, actual);
    }

    @Test
    void calculateTotalAmountWith7Discount(){
        when(stateTaxService.getTaxPercentage("RES")).thenReturn(new BigDecimal("21.5"));
        when(discountService.getDiscount(any())).thenReturn(new BigDecimal("7"));
        PriceRequest priceRequest = new PriceRequest("smartphone", new BigDecimal("1000"), 2, "RES");
        /*
        priceWithStateTax = (itemPrice * numberOfItems) * (1 + (stateTaxPercentage / 100))
        expected = (priceWithStateTax) * (1 - (discountPercentage / 100))
         */
        BigDecimal expected = new BigDecimal("2259.9");
        BigDecimal actual = pricing.calculateTotalAmount(
            priceRequest.getItemDescription(),
            priceRequest.getItemPrice(),
            priceRequest.getNumberOfItems(),
            priceRequest.getState()
        );
        assertEquals(expected, actual);
    }

    @Test
    void calculateTotalAmountWith15Discount(){
        when(stateTaxService.getTaxPercentage("TER")).thenReturn(new BigDecimal("0.5"));
        when(discountService.getDiscount(any())).thenReturn(new BigDecimal("15"));
        PriceRequest priceRequest = new PriceRequest("smartphone", new BigDecimal("1000"), 5, "TER");
        /*
        priceWithStateTax = (itemPrice * numberOfItems) * (1 + (stateTaxPercentage / 100))
        expected = (priceWithStateTax) * (1 - (discountPercentage / 100))
         */
        BigDecimal expected = new BigDecimal("4271.25");
        BigDecimal actual = pricing.calculateTotalAmount(
            priceRequest.getItemDescription(),
            priceRequest.getItemPrice(),
            priceRequest.getNumberOfItems(),
            priceRequest.getState()
        );
        assertEquals(expected, actual);
    }

    @Test
    void calculateTotalAmountWith19Discount(){
        when(stateTaxService.getTaxPercentage("RES")).thenReturn(new BigDecimal("21.5"));
        when(discountService.getDiscount(any())).thenReturn(new BigDecimal("19"));
        PriceRequest priceRequest = new PriceRequest("smartphone", new BigDecimal("1000"), 7, "RES");
        /*
        priceWithStateTax = (itemPrice * numberOfItems) * (1 + (stateTaxPercentage / 100))
        expected = (priceWithStateTax) * (1 - (discountPercentage / 100))
         */
        BigDecimal expected = new BigDecimal("6889.05");
        BigDecimal actual = pricing.calculateTotalAmount(
            priceRequest.getItemDescription(),
            priceRequest.getItemPrice(),
            priceRequest.getNumberOfItems(),
            priceRequest.getState()
        );
        assertEquals(expected, actual);
    }

    @Test
    void calculateTotalAmountWith25Discount(){
        when(stateTaxService.getTaxPercentage("RES")).thenReturn(new BigDecimal("21.5"));
        when(discountService.getDiscount(any())).thenReturn(new BigDecimal("25"));
        PriceRequest priceRequest = new PriceRequest("smartphone", new BigDecimal("1000"), 10, "RES");
        /*
        priceWithStateTax = (itemPrice * numberOfItems) * (1 + (stateTaxPercentage / 100))
        expected = (priceWithStateTax) * (1 - (discountPercentage / 100))
         */
        BigDecimal expected = new BigDecimal("9112.5");
        BigDecimal actual = pricing.calculateTotalAmount(
            priceRequest.getItemDescription(),
            priceRequest.getItemPrice(),
            priceRequest.getNumberOfItems(),
            priceRequest.getState()
        );
        assertEquals(expected, actual);
    }

}
