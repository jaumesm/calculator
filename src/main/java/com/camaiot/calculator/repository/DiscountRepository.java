package com.camaiot.calculator.repository;

import com.camaiot.calculator.repository.entity.Discount;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class DiscountRepository {

    public Discount findFirstByAmountLessThanOrEqualsOrderByAmountDesc(BigDecimal amount) {
        // TODO: implement
        return null;
    }

}
