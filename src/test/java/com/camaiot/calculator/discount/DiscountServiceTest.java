package com.camaiot.calculator.discount;

import com.camaiot.calculator.repository.DiscountRepository;
import com.camaiot.calculator.repository.entity.Discount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DiscountServiceTest {

    @Mock
    private DiscountRepository discountRepository;

    private DiscountService discountService;

    @BeforeEach
    void setUp() {
        discountService = new DiscountService(discountRepository);
    }

    @Test
    void getApplicableDiscount() {
        BigDecimal amount = new BigDecimal("2000");
        when(
            discountRepository.findFirstByAmountLessThanOrEqualsOrderByAmountDesc(amount)
        ).thenReturn(initDiscount(amount));

        BigDecimal actual = discountService.getDiscount(amount);

        assertNotNull(actual);
        assertTrue(BigDecimal.ZERO.compareTo(actual) < 0);
    }

    private Discount initDiscount(BigDecimal amount) {
        return new Discount.Builder()
            .withId(1l)
            .withAmount(amount)
            .withDiscountPercentage(new BigDecimal("7"))
            .build();
    }

    @Test
    void getNotApplicableDiscount() {
        when(discountRepository.findFirstByAmountLessThanOrEqualsOrderByAmountDesc(BigDecimal.ONE)).thenReturn(null);
        BigDecimal actual = discountService.getDiscount(BigDecimal.ONE);
        assertNull(actual);
    }
}
