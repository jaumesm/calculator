package com.camaiot.calculator.tax;

import com.camaiot.calculator.repository.SpecialTaxRepository;
import com.camaiot.calculator.repository.entity.SpecialTax;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SpecialTaxServiceTest {

    @Mock
    private SpecialTaxRepository specialTaxRepository;

    private SpecialTaxService specialTaxService;

    @BeforeEach
    void setUp() {
        specialTaxService = new SpecialTaxService(specialTaxRepository);
    }

    @Test
    void getTaxPercentageForSpecialItem() {
        when(specialTaxRepository.findByItemDescription("tobacco")).thenReturn(initSpecialTax());
        BigDecimal actual = specialTaxService.getTaxPercentage("tobacco");
        assertNotNull(actual);
    }

    @Test
    void getTaxPercentageForNormalItem() {
        when(specialTaxRepository.findByItemDescription("xxx")).thenReturn(null);
        BigDecimal actual = specialTaxService.getTaxPercentage("xxx");
        assertNull(actual);
    }

    private SpecialTax initSpecialTax() {
        return new SpecialTax.Builder("tobacco", new BigDecimal("50")).build();
    }

}
