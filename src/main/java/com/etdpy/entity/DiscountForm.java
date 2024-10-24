package com.etdpy.entity;

import jakarta.validation.constraints.NotEmpty;

public class DiscountForm {

    @NotEmpty(message = "折扣不能為空,如果沒有請填0")
    private Integer discount;

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
