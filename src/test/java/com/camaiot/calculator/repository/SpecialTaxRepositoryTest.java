package com.camaiot.calculator.repository;

import com.camaiot.calculator.repository.entity.SpecialTax;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SpecialTaxRepositoryTest {

    private final SpecialTaxRepository specialTaxRepository = new SpecialTaxRepository();

    @Test
    void findByExistingItemDescription() {
        SpecialTax expected = new SpecialTax.Builder("tobacco", new BigDecimal("50")).build();
        SpecialTax actual = specialTaxRepository.findByItemDescription("tobacco");
        assertNotNull(actual);
        assertEquals(expected.getTaxPercentage(), actual.getTaxPercentage());
    }

    @Test
    void findByNotExistingItemDescription() {
        SpecialTax actual = specialTaxRepository.findByItemDescription("xxx");
        assertNull(actual);
    }

}
