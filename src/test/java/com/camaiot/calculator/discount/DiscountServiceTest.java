package com.camaiot.calculator.discount;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceTest {

    private final DiscountService discountService = new DiscountService();

    @Test
    void getApplicableDiscount() {
        BigDecimal actual = discountService.getDiscount(new BigDecimal("2000"));
        assertNotNull(actual);
        assertTrue(BigDecimal.ZERO.compareTo(actual) < 0);
    }

    @Test
    void getNotApplicableDiscount() {
        BigDecimal actual = discountService.getDiscount(BigDecimal.ONE);
        assertNull(actual);
    }
}
