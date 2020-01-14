package com.camaiot.calculator.repository;

import com.camaiot.calculator.repository.entity.StateTax;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateTaxRepositoryTest {

    final StateTaxRepository stateTaxRepository = new StateTaxRepository();

    @Test
    void findByExistingState() {
        StateTax actual = stateTaxRepository.findByState("BAL");
        assertNotNull(actual);
    }

    @Test
    void findByNotExistingState() {
        StateTax actual = stateTaxRepository.findByState("XXX");
        assertNull(actual);
    }
}
