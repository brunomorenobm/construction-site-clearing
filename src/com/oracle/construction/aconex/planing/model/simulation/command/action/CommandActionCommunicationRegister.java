package com.oracle.construction.aconex.planing.model.simulation.command.action;

import com.oracle.construction.aconex.planing.model.Context;
import com.oracle.construction.aconex.planing.model.billing.BillItem;
import com.oracle.construction.aconex.planing.model.billing.Item;
import com.oracle.construction.aconex.planing.model.simulation.command.Command;

public class CommandActionCommunicationRegister implements CommandAction {

    @Override
    public void execute(Command command, Context context) {
        if (command.isValid()){
            context.getBill().addBillItem(new BillItem(Item.COMMUNICATION, 1l));
        }
    }
}
