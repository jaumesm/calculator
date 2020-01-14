package com.camaiot.calculator.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Discount {

    @Id
    private Long id;
    private BigDecimal discountPercentage;
    private BigDecimal amount;

    public Discount() {
    }

    private Discount(Builder builder) {
        this.id = builder.id;
        this.discountPercentage = builder.discountPercentage;
        this.amount = builder.amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public static class Builder {
        private Long id;
        private BigDecimal discountPercentage;
        private BigDecimal amount;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withDiscountPercentage(BigDecimal discountPercentage) {
            this.discountPercentage = discountPercentage;
            return this;
        }

        public Builder withAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Discount build() {
            return new Discount(this);
        }
    }

}
