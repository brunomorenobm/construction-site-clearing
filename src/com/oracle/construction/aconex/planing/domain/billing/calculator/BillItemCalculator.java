package com.oracle.construction.aconex.planing.domain.billing.calculator;

import com.oracle.construction.aconex.planing.domain.billing.BillItem;

public interface BillItemCalculator {

   Double calculate(BillItem item);
}
