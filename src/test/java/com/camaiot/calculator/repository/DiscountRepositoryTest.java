package com.camaiot.calculator.repository;

import com.camaiot.calculator.repository.entity.Discount;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DiscountRepositoryTest {

    private final DiscountRepository discountRepository = new DiscountRepository();

    @Test
    void find25() {
        BigDecimal expected = new BigDecimal("25");
        Discount actual = discountRepository
            .findFirstByAmountLessThanOrEqualsOrderByAmountDesc(new BigDecimal("19800.98"));
        assertEquals(expected, actual.getDiscountPercentage());
    }

    @Test
    void find19() {
        BigDecimal expected = new BigDecimal("19");
        Discount actual = discountRepository
            .findFirstByAmountLessThanOrEqualsOrderByAmountDesc(new BigDecimal("7500"));
        assertEquals(expected, actual.getDiscountPercentage());
    }

    @Test
    void find15() {
        BigDecimal expected = new BigDecimal("15");
        Discount actual = discountRepository
            .findFirstByAmountLessThanOrEqualsOrderByAmountDesc(new BigDecimal("5000"));
        assertEquals(expected, actual.getDiscountPercentage());
    }

    @Test
    void find7() {
        BigDecimal expected = new BigDecimal("7");
        Discount actual = discountRepository
            .findFirstByAmountLessThanOrEqualsOrderByAmountDesc(new BigDecimal("2000"));
        assertEquals(expected, actual.getDiscountPercentage());
    }

    @Test
    void find3() {
        BigDecimal expected = new BigDecimal("3");
        Discount actual = discountRepository
            .findFirstByAmountLessThanOrEqualsOrderByAmountDesc(new BigDecimal("1000"));
        assertEquals(expected, actual.getDiscountPercentage());
    }

    @Test
    void findNull() {
        Discount actual = discountRepository
            .findFirstByAmountLessThanOrEqualsOrderByAmountDesc(BigDecimal.ONE);
        assertNull(actual);
    }

}
