package com.camaiot.calculator.price;

import java.math.BigDecimal;

public interface Pricing {

    BigDecimal calculateTotalAmount(
        String itemDescription,
        BigDecimal itemPrice,
        Integer numberOfItems,
        String state
    );

}
