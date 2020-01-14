package com.camaiot.calculator.discount;

import com.camaiot.calculator.repository.DiscountRepository;
import com.camaiot.calculator.repository.entity.Discount;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DiscountService {

    DiscountRepository discountRepository;

    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public BigDecimal getDiscount(BigDecimal amount) {
        Discount discount = discountRepository.findFirstByAmountLessThanOrEqualsOrderByAmountDesc(amount);
        if (discount != null) {
            return discount.getDiscountPercentage();
        }
        return null;
    }

}
