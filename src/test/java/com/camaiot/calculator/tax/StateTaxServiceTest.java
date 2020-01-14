package com.camaiot.calculator.tax;

import com.camaiot.calculator.exception.BadRequestException;
import com.camaiot.calculator.repository.StateTaxRepository;
import com.camaiot.calculator.repository.entity.StateTax;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StateTaxServiceTest {

    @Mock
    private StateTaxRepository stateTaxRepository;

    private StateTaxService stateTaxService;

    @BeforeEach
    void setUp() {
        stateTaxService = new StateTaxService(stateTaxRepository);
    }

    @Test
    void getTaxPercentageForExistingState() {
        when(stateTaxRepository.findByState("BAL")).thenReturn(initStateTaxForBAL());
        BigDecimal actual = stateTaxService.getTaxPercentage("BAL");
        assertNotNull(actual);
        assertTrue(BigDecimal.ZERO.compareTo(actual) < 0);
    }

    private StateTax initStateTaxForBAL() {
        return new StateTax.Builder("BAL", new BigDecimal("18.3")).build();
    }

    @Test
    void throwBadRequestForNotExistingState() {
        when(stateTaxRepository.findByState("XXX")).thenReturn(null);
        assertThrows(BadRequestException.class, () -> stateTaxService.getTaxPercentage("XXX"));
    }

}
