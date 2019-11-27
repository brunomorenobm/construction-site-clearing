package com.oracle.construction.aconex.simulation.domain.simulation.command.action;

import com.oracle.construction.aconex.simulation.domain.simulation.billing.BillItem;
import com.oracle.construction.aconex.simulation.domain.simulation.billing.Item;
import com.oracle.construction.aconex.simulation.domain.simulation.billing.SimulationBill;
import com.oracle.construction.aconex.simulation.domain.mock.BlockDataGenerator;
import com.oracle.construction.aconex.simulation.domain.simulation.Context;
import com.oracle.construction.aconex.simulation.domain.simulation.command.NavigateCommand;
import com.oracle.construction.aconex.simulation.exception.SimulationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.when;

class CommunicationRegisterCommandActionTest {

    @Mock
    Context context;
    CommandAction action;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        when(context.getBlocks()).thenReturn(BlockDataGenerator.simpleBlocks().get());
        when(context.getBill()).thenReturn(new SimulationBill());
        action = new CommunicationRegisterCommandAction();

    }

    @Test
    void execute() throws SimulationException {
        Assertions.assertDoesNotThrow(() -> action.execute(new NavigateCommand("q"), context));
        Assertions.assertDoesNotThrow(() -> action.execute(new NavigateCommand("a 20"), context));
        List<BillItem> billingItems = context.getBill().getBillItems();
        Assertions.assertEquals(2, billingItems.size());
        Assertions.assertEquals(new BillItem(Item.COMMUNICATION, 1l), billingItems.get(0));
        Assertions.assertEquals(new BillItem(Item.COMMUNICATION, 1l), billingItems.get(1));
        Assertions.assertEquals(2d, context.getBill().getTotal());
    }
}