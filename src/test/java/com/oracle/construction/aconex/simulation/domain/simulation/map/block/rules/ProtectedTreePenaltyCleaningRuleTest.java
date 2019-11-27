package com.oracle.construction.aconex.simulation.domain.simulation.map.block.rules;

import com.oracle.construction.aconex.simulation.domain.simulation.billing.BillItem;
import com.oracle.construction.aconex.simulation.domain.simulation.billing.Item;
import com.oracle.construction.aconex.simulation.domain.simulation.billing.SimulationBill;
import com.oracle.construction.aconex.simulation.domain.simulation.Context;
import com.oracle.construction.aconex.simulation.domain.simulation.map.CardinalDirection;
import com.oracle.construction.aconex.simulation.domain.simulation.map.Coordinate;
import com.oracle.construction.aconex.simulation.exception.SimulationException;
import com.oracle.construction.aconex.simulation.exception.rules.ViolateRuleProtectedTreeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.when;

class ProtectedTreePenaltyCleaningRuleTest {

    CleaningRule cleaningRule;

    @Mock
    Context context;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        cleaningRule = new ProtectedTreePenaltyCleaningRule();
    }

    @Test
    void enteringFromEastWithProtectedTree() throws SimulationException {

        // Test data
        when(this.context.getBill()).thenReturn(new SimulationBill());
        // From East - RULE 3
        when(this.context.getCardinalDirection()).thenReturn(CardinalDirection.E);
        // Outside the Map, Initial
        when(this.context.getCurrentPosition()).thenReturn(new Coordinate(0, 0));
        when(this.context.getInitialPosition()).thenReturn(new Coordinate(-1, 0));

        // Method Execution
        Assertions.assertDoesNotThrow(() -> cleaningRule.apply(this.context));

        // Data Verification
        List<BillItem> billingItems = context.getBill().getBillItems();
        Assertions.assertEquals(1, billingItems.size());
        Assertions.assertEquals(new BillItem(Item.PENALTY_PROTECTED_TREE, 1l), billingItems.get(0));
    }


    @Test
    void cleaningEastWithProtectedTree() throws SimulationException {

        // Test data
        when(this.context.getBill()).thenReturn(new SimulationBill());
        // Specific Cardinal Direction
        when(this.context.getCardinalDirection()).thenReturn(CardinalDirection.E);
        // Any Position
        when(this.context.getCurrentPosition()).thenReturn(new Coordinate(1, 1));
        when(this.context.getInitialPosition()).thenReturn(new Coordinate(-1, 0));

        // Method Execution
        Assertions.assertThrows(ViolateRuleProtectedTreeException.class, () -> cleaningRule.apply(this.context));

        // Data Verification
        List<BillItem> billingItems = context.getBill().getBillItems();
        Assertions.assertEquals(1, billingItems.size());
        Assertions.assertEquals(new BillItem(Item.PENALTY_PROTECTED_TREE, 1l), billingItems.get(0));
    }


    @Test
    void cleaningWithProtectedTree() throws SimulationException {

        // Test data
        when(this.context.getBill()).thenReturn(new SimulationBill());
        // Any Cardinal Direction
        when(this.context.getCardinalDirection()).thenReturn(CardinalDirection.N);
        // Any position
        when(this.context.getCurrentPosition()).thenReturn(new Coordinate(2, 2));
        when(this.context.getInitialPosition()).thenReturn(new Coordinate(-1, 0));

        // Method Execution
        Assertions.assertThrows(ViolateRuleProtectedTreeException.class, () -> cleaningRule.apply(this.context));

        // Data Verification
        List<BillItem> billingItems = context.getBill().getBillItems();
        Assertions.assertEquals(1, billingItems.size());
        Assertions.assertEquals(new BillItem(Item.PENALTY_PROTECTED_TREE, 1l), billingItems.get(0));
    }
}