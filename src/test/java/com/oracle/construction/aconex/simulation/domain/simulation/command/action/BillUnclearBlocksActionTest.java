package com.oracle.construction.aconex.simulation.domain.simulation.command.action;

import com.oracle.construction.aconex.simulation.domain.simulation.billing.BillItem;
import com.oracle.construction.aconex.simulation.domain.simulation.billing.Item;
import com.oracle.construction.aconex.simulation.domain.simulation.billing.SimulationBill;
import com.oracle.construction.aconex.simulation.domain.mock.BlockDataGenerator;
import com.oracle.construction.aconex.simulation.domain.simulation.Context;
import com.oracle.construction.aconex.simulation.exception.SimulationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.when;

class BillUnclearBlocksActionTest {

    @Mock
    Context context;
    Action action;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        when(context.getBlocks()).thenReturn(BlockDataGenerator.simpleBlocks().get());
        when(context.getBill()).thenReturn(new SimulationBill());
        action = new BillUnclearBlocksAction();

    }

    @Test
    void execute() throws SimulationException {
        Assertions.assertDoesNotThrow(() -> action.execute(context));
        List<BillItem> billingItems = context.getBill().getBillItems();
        Assertions.assertEquals(1, billingItems.size());
        Assertions.assertEquals(new BillItem(Item.UNCLEAR_BLOCK, 12l), billingItems.get(0));
        Assertions.assertEquals(36d, context.getBill().getTotal());
    }
}