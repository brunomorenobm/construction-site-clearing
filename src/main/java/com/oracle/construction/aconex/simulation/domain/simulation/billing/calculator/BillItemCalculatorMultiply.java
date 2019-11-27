package com.oracle.construction.aconex.simulation.domain.simulation.billing.calculator;

import com.oracle.construction.aconex.simulation.domain.simulation.billing.BillItem;

public class BillItemCalculatorMultiply implements BillItemCalculator {

    public Double calculate(BillItem item) {
        return item.getItem().getCredit() * item.getQuantity();
    }
}
