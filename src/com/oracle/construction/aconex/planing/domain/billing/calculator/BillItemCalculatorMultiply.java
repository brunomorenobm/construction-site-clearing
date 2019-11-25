package com.oracle.construction.aconex.planing.domain.billing.calculator;

import com.oracle.construction.aconex.planing.domain.billing.BillItem;

public class BillItemCalculatorMultiply implements BillItemCalculator {

    public Double calculate(BillItem item) {
        return item.getItem().getCredit() * item.getQuantity();
    }
}
