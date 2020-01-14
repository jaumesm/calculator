package com.camaiot.calculator.repository;

import com.camaiot.calculator.repository.entity.SpecialTax;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class SpecialTaxRepository {

    /* FIXME: Internal map for Stubbing DataBase connection */
    private Map<String, SpecialTax> specialTaxMap;

    public SpecialTaxRepository() {
        this.specialTaxMap = initSpecialTaxMap();
    }

    private Map<String, SpecialTax> initSpecialTaxMap() {
        ConcurrentHashMap<String, SpecialTax> specialTaxmap = new ConcurrentHashMap<>();
        specialTaxmap.put(
            "tobacco",
            new SpecialTax.Builder("tobacco", new BigDecimal("50")).build()
        );
        return specialTaxmap;
    }

    public SpecialTax findByItemDescription(String itemDescription) {
        return this.specialTaxMap.get(itemDescription);
    }

}
