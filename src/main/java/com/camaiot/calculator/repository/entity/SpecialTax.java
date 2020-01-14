package com.camaiot.calculator.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class SpecialTax {

    @Id
    private String itemDescription;
    private BigDecimal taxPercentage;

    public SpecialTax() {
    }

    public SpecialTax(Builder builder) {
        this.itemDescription = builder.itemDescription;
        this.taxPercentage = builder.taxPercentage;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public BigDecimal getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(BigDecimal taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public static class Builder {
        private String itemDescription;
        private BigDecimal taxPercentage;

        public Builder(String itemDescription, BigDecimal taxPercentage) {
            this.itemDescription = itemDescription;
            this.taxPercentage = taxPercentage;
        }

        public SpecialTax build() {
            return new SpecialTax(this);
        }
    }

}
