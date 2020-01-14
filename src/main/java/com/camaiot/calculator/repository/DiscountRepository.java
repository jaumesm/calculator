package com.camaiot.calculator.repository;

import com.camaiot.calculator.repository.entity.Discount;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class DiscountRepository {

    /* FIXME: Internal map for Stubbing DataBase connection */
    private Map<BigDecimal, Discount> discountMap;

    public DiscountRepository() {
        this.discountMap = initOrderedDiscountMap();
    }

    public Discount findFirstByAmountLessThanOrEqualsOrderByAmountDesc(BigDecimal amount) {
        return discountMap.entrySet().stream()
            .filter(entry -> entry.getKey().compareTo(amount) <= 0)
            .map(Map.Entry::getValue)
            .findFirst()
            .orElse(null);
    }

    /* FIXME: Connect to DataBase instead this Stub */
    private Map<BigDecimal, Discount> initOrderedDiscountMap() {
        LinkedHashMap<BigDecimal, Discount> discounts = new LinkedHashMap<>();
        discounts.put(
            new BigDecimal("10000"),
            new Discount.Builder()
                .withId(1l)
                .withAmount(new BigDecimal("10000"))
                .withDiscountPercentage(new BigDecimal("25"))
                .build()
        );
        discounts.put(
            new BigDecimal("7500"),
            new Discount.Builder()
                .withId(1l)
                .withAmount(new BigDecimal("7500"))
                .withDiscountPercentage(new BigDecimal("19"))
                .build()
        );
        discounts.put(
            new BigDecimal("5000"),
            new Discount.Builder()
                .withId(1l)
                .withAmount(new BigDecimal("5000"))
                .withDiscountPercentage(new BigDecimal("15"))
                .build()
        );
        discounts.put(
            new BigDecimal("2000"),
            new Discount.Builder()
                .withId(1l)
                .withAmount(new BigDecimal("2000"))
                .withDiscountPercentage(new BigDecimal("7"))
                .build()
        );

        discounts.put(
            new BigDecimal("1000"),
            new Discount.Builder()
                .withId(1l)
                .withAmount(new BigDecimal("1000"))
                .withDiscountPercentage(new BigDecimal("3"))
                .build()
        );
        return Collections.synchronizedMap(discounts);
    }

}
