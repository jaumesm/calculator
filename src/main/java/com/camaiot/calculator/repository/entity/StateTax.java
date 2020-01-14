package com.camaiot.calculator.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class StateTax {

    @Id
    private String state;

    private BigDecimal taxPercentage;

    public StateTax() {
    }

    public StateTax(Builder builder) {
        this.state = builder.state;
        this.taxPercentage = builder.taxPercentage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(BigDecimal taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public static class Builder {
        private String state;
        private BigDecimal taxPercentage;

        public Builder(String state, BigDecimal taxPercentage) {
            this.state = state;
            this.taxPercentage = taxPercentage;
        }

        public StateTax build() {
            return new StateTax(this);
        }
    }
}
