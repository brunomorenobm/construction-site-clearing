package com.oracle.construction.aconex.simulation.domain.simulation.map.block;

import com.oracle.construction.aconex.simulation.domain.billing.BillItem;
import com.oracle.construction.aconex.simulation.domain.billing.Item;
import com.oracle.construction.aconex.simulation.domain.billing.SimulationBill;
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

class BlockProtectedTreeTest {

    Block block;

    @Mock
    Context context;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        // Test data
        when(this.context.getBill()).thenReturn(new SimulationBill());
    }

    @Test
    void CleanPassThroughStartingFromEast() throws SimulationException {
        // Outside the Map, Initial
        when(this.context.getCardinalDirection()).thenReturn(CardinalDirection.E);
        when(this.context.getCurrentPosition()).thenReturn(new Coordinate(0, 0));
        when(this.context.getInitialPosition()).thenReturn(new Coordinate(-1, 0));

        block = new BlockFactory().createBlock(BlockType.T);
        block.setCoordinate(new Coordinate(0, 0));

        // Set different ending coordinate to simulate pass through
        Assertions.assertDoesNotThrow(() -> block.clean(this.context, new Coordinate(3, 1)));

        // Data Verification
        List<BillItem> billingItems = context.getBill().getBillItems();
        Assertions.assertEquals(1, billingItems.size());
        Assertions.assertEquals(new BillItem(Item.PENALTY_PROTECTED_TREE, 1l), billingItems.get(0));
    }


    @Test
    void CleanPassThrough() throws SimulationException {

        when(this.context.getCardinalDirection()).thenReturn(CardinalDirection.W);
        when(this.context.getCurrentPosition()).thenReturn(new Coordinate(1, 1));
        when(this.context.getInitialPosition()).thenReturn(new Coordinate(-1, 0));


        block = new BlockFactory().createBlock(BlockType.T);
        block.setCoordinate(new Coordinate(1, 1));

        // Set equal ending coordinate to simulate the stop
        Assertions.assertThrows(ViolateRuleProtectedTreeException.class, () -> block.clean(this.context, new Coordinate(3, 1)));

        // Data Verification
        List<BillItem> billingItems = context.getBill().getBillItems();
        Assertions.assertEquals(1, billingItems.size());
        Assertions.assertEquals(new BillItem(Item.PENALTY_PROTECTED_TREE, 1l), billingItems.get(0));
    }


    @Test
    void CleanPassStop() throws SimulationException {

        when(this.context.getCardinalDirection()).thenReturn(CardinalDirection.E);
        when(this.context.getCurrentPosition()).thenReturn(new Coordinate(1, 1));
        when(this.context.getInitialPosition()).thenReturn(new Coordinate(-1, 0));


        block = new BlockFactory().createBlock(BlockType.T);
        block.setCoordinate(new Coordinate(1, 1));

        // Set equal ending coordinate to simulate the stop
        Assertions.assertThrows( ViolateRuleProtectedTreeException.class, () -> block.clean(this.context, new Coordinate(1, 1)));

        // Data Verification
        List<BillItem> billingItems = context.getBill().getBillItems();
        Assertions.assertEquals(1, billingItems.size());
        Assertions.assertEquals(new BillItem(Item.PENALTY_PROTECTED_TREE, 1l), billingItems.get(0));
    }
}