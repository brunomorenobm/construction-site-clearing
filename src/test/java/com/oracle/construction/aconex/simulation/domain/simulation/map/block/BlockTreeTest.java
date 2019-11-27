package com.oracle.construction.aconex.simulation.domain.simulation.map.block;

import com.oracle.construction.aconex.simulation.domain.billing.BillItem;
import com.oracle.construction.aconex.simulation.domain.billing.Item;
import com.oracle.construction.aconex.simulation.domain.billing.SimulationBill;
import com.oracle.construction.aconex.simulation.domain.simulation.Context;
import com.oracle.construction.aconex.simulation.domain.simulation.map.CardinalDirection;
import com.oracle.construction.aconex.simulation.domain.simulation.map.Coordinate;
import com.oracle.construction.aconex.simulation.exception.SimulationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.when;

class BlockTreeTest {

    Block block;

    @Mock
    Context context;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        // Test data
        when(this.context.getBill()).thenReturn(new SimulationBill());
        // From East - RULE 3
        when(this.context.getCardinalDirection()).thenReturn(CardinalDirection.E);
        // Outside the Map, Initial
        when(this.context.getCurrentPosition()).thenReturn(new Coordinate(-1, 0));
        when(this.context.getInitialPosition()).thenReturn(new Coordinate(-1, 0));
    }

    @Test
    void CleanPassThrough() throws SimulationException {

        block = new BlockFactory().createBlock(BlockType.t);
        block.setCoordinate(new Coordinate(1, 1));

        // Set different ending coordinate to simulate pass through
        Assertions.assertDoesNotThrow(() -> block.clean(this.context, new Coordinate(3, 1)));

        // Data Verification
        List<BillItem> billingItems = context.getBill().getBillItems();
        Assertions.assertEquals(2, billingItems.size());
        Assertions.assertEquals(new BillItem(Item.FUEL, 2l), billingItems.get(0));
        Assertions.assertEquals(new BillItem(Item.PENALTY_PAINT, 1l), billingItems.get(1));
    }

    @Test
    void CleanSecondPassThrough() throws SimulationException {

        block = new BlockFactory().createBlock(BlockType.t);
        block.setCoordinate(new Coordinate(1, 1));

        // Set different ending coordinate to simulate pass through
        Assertions.assertDoesNotThrow(() -> block.clean(this.context, new Coordinate(3, 1)));
        Assertions.assertDoesNotThrow(() -> block.clean(this.context, new Coordinate(3, 1)));

        // Data Verification
        List<BillItem> billingItems = context.getBill().getBillItems();
        Assertions.assertEquals(4, billingItems.size());
        Assertions.assertEquals(new BillItem(Item.FUEL, 2l), billingItems.get(0));
        Assertions.assertEquals(new BillItem(Item.PENALTY_PAINT, 1l), billingItems.get(1));
        Assertions.assertEquals(new BillItem(Item.FUEL, 1l), billingItems.get(2));
        Assertions.assertEquals(new BillItem(Item.PENALTY_PAINT, 1l), billingItems.get(3));

    }

    @Test
    void CleanPassStop() throws SimulationException {

        block = new BlockFactory().createBlock(BlockType.t);
        block.setCoordinate(new Coordinate(1, 1));

        // Set equal ending coordinate to simulate the stop
        Assertions.assertDoesNotThrow(() -> block.clean(this.context, new Coordinate(1, 1)));

        // Data Verification
        List<BillItem> billingItems = context.getBill().getBillItems();
        Assertions.assertEquals(1, billingItems.size());
        Assertions.assertEquals(new BillItem(Item.FUEL, 2l), billingItems.get(0));
    }

    @Test
    void CleanSecondPassStop() throws SimulationException {

        block = new BlockFactory().createBlock(BlockType.t);
        block.setCoordinate(new Coordinate(1, 1));

        // Set equal ending coordinate to simulate the stop
        Assertions.assertDoesNotThrow(() -> block.clean(this.context, new Coordinate(1, 1)));
        Assertions.assertDoesNotThrow(() -> block.clean(this.context, new Coordinate(1, 1)));

        // Data Verification
        List<BillItem> billingItems = context.getBill().getBillItems();
        Assertions.assertEquals(2, billingItems.size());
        Assertions.assertEquals(new BillItem(Item.FUEL, 2l), billingItems.get(0));
        Assertions.assertEquals(new BillItem(Item.FUEL, 1l), billingItems.get(1));
    }
}