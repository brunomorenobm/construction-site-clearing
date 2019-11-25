package com.oracle.construction.aconex.planing.domain.simulation.command.action;

import com.oracle.construction.aconex.planing.domain.simulation.Context;
import com.oracle.construction.aconex.planing.domain.billing.BillItem;
import com.oracle.construction.aconex.planing.domain.billing.Item;
import com.oracle.construction.aconex.planing.domain.simulation.command.Command;

public class CommandActionCommunicationRegister implements CommandAction {

    @Override
    public void execute(Command command, Context context) {
        if (command.isValid()){
            context.getBill().addBillItem(new BillItem(Item.COMMUNICATION, 1l));
        }
    }
}
