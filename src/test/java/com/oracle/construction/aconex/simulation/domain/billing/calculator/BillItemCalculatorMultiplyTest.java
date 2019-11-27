package com.oracle.construction.aconex.simulation.domain.billing.calculator;

import com.oracle.construction.aconex.simulation.domain.billing.BillItem;
import com.oracle.construction.aconex.simulation.domain.billing.Item;
import com.oracle.construction.aconex.simulation.exception.SimulationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BillItemCalculatorMultiplyTest {
    BillItemCalculatorMultiply billItemCalculatorMultiply = new BillItemCalculatorMultiply();

    @BeforeEach
    void setUp() {
        billItemCalculatorMultiply = new BillItemCalculatorMultiply();
    }

    @Test
    void calculate() throws SimulationException {
        Assertions.assertEquals(3d, billItemCalculatorMultiply.calculate(new BillItem(Item.COMMUNICATION, 3l)), 0.001);
        Assertions.assertEquals(3d, billItemCalculatorMultiply.calculate(new BillItem(Item.FUEL, 3l)), 0.001);
        Assertions.assertEquals(6d, billItemCalculatorMultiply.calculate(new BillItem(Item.PENALTY_PAINT, 3l)), 0.001);
        Assertions.assertEquals(9d, billItemCalculatorMultiply.calculate(new BillItem(Item.UNCLEAR_BLOCK, 3l)), 0.001);
        Assertions.assertEquals(30d, billItemCalculatorMultiply.calculate(new BillItem(Item.PENALTY_PROTECTED_TREE, 3l)), 0.001);
    }
}