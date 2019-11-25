package com.oracle.construction.aconex.planing.model.simulation.command.action;

import com.oracle.construction.aconex.planing.exception.SimulationException;
import com.oracle.construction.aconex.planing.model.Context;
import com.oracle.construction.aconex.planing.model.billing.BillItem;
import com.oracle.construction.aconex.planing.model.billing.Item;
import com.oracle.construction.aconex.planing.model.simulation.map.block.BlockType;

public class ActionUnclearBlocks implements Action {

    /**
     * RULE 4 Advance: this command takes a positive integer parameter to define the number of squares the bulldozer should move forwards (in whatever direction it is currently facing);
     *
     * @param context
     * @throws SimulationException
     */
    @Override
    public void execute(Context context) throws SimulationException {

        long unclearedBlocks = context.getBlocks().stream()
                .flatMap(line -> line.stream()
                        .filter(block -> block.getCleanedQuantity() == 0 && block.getBlockType()!= BlockType.T)
                ).count();

        context.getBill().addBillItem(new BillItem(Item.UNCLEAR_BLOCK, unclearedBlocks));
    }
}
