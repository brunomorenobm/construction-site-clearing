package com.oracle.construction.aconex.simulation.domain.simulation.map.block.rules;

import com.oracle.construction.aconex.simulation.domain.billing.BillItem;
import com.oracle.construction.aconex.simulation.domain.billing.Item;
import com.oracle.construction.aconex.simulation.domain.billing.SimulationBill;
import com.oracle.construction.aconex.simulation.domain.simulation.Context;
import com.oracle.construction.aconex.simulation.exception.SimulationException;
import com.oracle.construction.aconex.simulation.exception.rules.InterruptSimulationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.when;

class CleaningRuleDoubleFuelConsumptionTest {

    CleaningRule cleaningRule;

    @Mock
    Context context;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        cleaningRule = new CleaningRuleDoubleFuelConsumption();

    }

    @Test
    void apply() throws InterruptSimulationException, SimulationException {

        // Test Data
        when(this.context.getBill()).thenReturn(new SimulationBill());

        // Method Execution
        cleaningRule.apply(this.context);

        // Data Verification
        List<BillItem> billingItems = context.getBill().getBillItems();
        Assertions.assertEquals(1, billingItems.size());
        Assertions.assertEquals(new BillItem(Item.FUEL, 2l), billingItems.get(0));
    }
}