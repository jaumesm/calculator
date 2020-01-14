package com.camaiot.calculator.tax;

import com.camaiot.calculator.exception.BadRequestException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class StateTaxServiceTest {

    private final StateTaxService stateTaxService = new StateTaxService();

    @Test
    void getTaxPercentageForExistingState() {
        BigDecimal actual = stateTaxService.getTaxPercentage("BAL");
        assertNotNull(actual);
        assertTrue(BigDecimal.ZERO.compareTo(actual) < 0);
    }

    @Test
    void throwBadRequestForNotExistingState() {
        assertThrows(BadRequestException.class, () -> stateTaxService.getTaxPercentage("XXX"));
    }

}
