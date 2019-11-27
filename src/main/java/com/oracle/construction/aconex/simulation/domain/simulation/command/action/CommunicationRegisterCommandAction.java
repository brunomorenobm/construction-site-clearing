package com.oracle.construction.aconex.simulation.domain.simulation.command.action;

import com.oracle.construction.aconex.simulation.domain.simulation.Context;
import com.oracle.construction.aconex.simulation.domain.simulation.billing.BillItem;
import com.oracle.construction.aconex.simulation.domain.simulation.billing.Item;
import com.oracle.construction.aconex.simulation.domain.simulation.command.Command;
import com.oracle.construction.aconex.simulation.exception.SimulationException;

public class CommunicationRegisterCommandAction implements CommandAction {

    @Override
    public void execute(Command command, Context context) throws SimulationException {
        if (command.isValid()){
            context.getBill().addBillItem(new BillItem(Item.COMMUNICATION, 1l));
        }
    }
}
