package com.oracle.construction.aconex.simulation.domain.simulation.billing.calculator;

import com.oracle.construction.aconex.simulation.domain.simulation.billing.BillItem;

public interface BillItemCalculator {

   Double calculate(BillItem item);
}
