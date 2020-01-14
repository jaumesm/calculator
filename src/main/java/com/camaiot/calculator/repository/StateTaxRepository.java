package com.camaiot.calculator.repository;

import com.camaiot.calculator.repository.entity.StateTax;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class StateTaxRepository {

    Map<String, StateTax> stateTaxMap;

    public StateTaxRepository() {
        this.stateTaxMap = initStateTaxMap();
    }

    public StateTax findByState(String state) {
        return stateTaxMap.get(state);
    }

    /* FIXME: Connect to DataBase instead this Stub */
    private Map<String, StateTax> initStateTaxMap() {
        ConcurrentHashMap<String, StateTax> map = new ConcurrentHashMap<>();
        map.put("BAL", new StateTax.Builder("BAL", new BigDecimal("18.3")).build());
        map.put("CAN", new StateTax.Builder("CAN", new BigDecimal("4.7")).build());
        map.put("CYM", new StateTax.Builder("CYM", new BigDecimal("8.1")).build());
        map.put("TER", new StateTax.Builder("TER", new BigDecimal("0.5")).build());
        map.put("RES", new StateTax.Builder("RES", new BigDecimal("21.5")).build());

        return map;
    }
}
