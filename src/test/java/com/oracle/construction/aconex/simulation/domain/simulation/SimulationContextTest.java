package com.oracle.construction.aconex.simulation.domain.simulation;

import com.oracle.construction.aconex.simulation.domain.simulation.billing.SimulationBill;
import com.oracle.construction.aconex.simulation.domain.mock.BlockDataGenerator;
import com.oracle.construction.aconex.simulation.domain.simulation.map.CardinalDirection;
import com.oracle.construction.aconex.simulation.domain.simulation.map.Coordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimulationContextTest {

    @Test
    void init() {
        Context context = new SimulationContext(BlockDataGenerator.simpleBlocks().get());
        context.init();

        Assertions.assertEquals(new SimulationBill(), context.getBill());
        Assertions.assertEquals(new Coordinate(-1, 0), context.getInitialPosition());
        Assertions.assertEquals(new Coordinate(-1, 0), context.getCurrentPosition());
        Assertions.assertEquals(CardinalDirection.E, context.getCardinalDirection());
    }
}