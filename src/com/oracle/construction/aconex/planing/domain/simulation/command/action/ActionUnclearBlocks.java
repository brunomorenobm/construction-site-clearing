package com.oracle.construction.aconex.planing.domain.simulation.command.action;

import com.oracle.construction.aconex.planing.exception.SimulationException;
import com.oracle.construction.aconex.planing.domain.Context;
import com.oracle.construction.aconex.planing.domain.billing.BillItem;
import com.oracle.construction.aconex.planing.domain.billing.Item;
import com.oracle.construction.aconex.planing.domain.simulation.map.block.BlockType;

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
