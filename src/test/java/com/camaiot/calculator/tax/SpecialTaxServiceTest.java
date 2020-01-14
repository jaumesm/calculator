package com.camaiot.calculator.tax;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class SpecialTaxServiceTest {

    private final SpecialTaxService specialTaxService = new SpecialTaxService();

    @Test
    void getTaxPercentageForSpecialItem() {
        BigDecimal actual = specialTaxService.getTaxPercentage("tobacco");
        assertNotNull(actual);
    }

    @Test
    void getTaxPercentageForNormalItem() {
        BigDecimal actual = specialTaxService.getTaxPercentage("xxx");
        assertNull(actual);
    }

}
