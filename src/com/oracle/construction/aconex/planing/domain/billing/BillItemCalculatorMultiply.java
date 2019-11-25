package com.oracle.construction.aconex.planing.domain.billing;

public class BillItemCalculatorMultiply implements BillItemCalculator {

    public Double calculate(BillItem item) {
        return item.getItem().getCredit() * item.getQuantity();
    }
}
