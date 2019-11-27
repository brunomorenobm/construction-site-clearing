package com.oracle.construction.aconex.simulation.domain.simulation.billing;

import com.oracle.construction.aconex.simulation.exception.SimulationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BillItemTest {

    @Test
    void billItemError() {
        assertThrows(SimulationException.class, () -> new BillItem(Item.FUEL, -1l));
        assertThrows(SimulationException.class, () -> new BillItem(Item.COMMUNICATION, -10l));
        assertThrows(SimulationException.class, () -> new BillItem(Item.COMMUNICATION, null));
        assertThrows(SimulationException.class, () -> new BillItem(null, 0l));
        assertThrows(SimulationException.class, () -> new BillItem(null, null));
    }

    @Test
    void billItem() {
        assertDoesNotThrow(() -> new BillItem(Item.FUEL, 1l));
        assertDoesNotThrow(() -> new BillItem(Item.COMMUNICATION, 10l));
        assertDoesNotThrow(() -> new BillItem(Item.PENALTY_PAINT, 100000l));
        assertDoesNotThrow(() -> new BillItem(Item.PENALTY_PROTECTED_TREE, 00110l));
    }

}