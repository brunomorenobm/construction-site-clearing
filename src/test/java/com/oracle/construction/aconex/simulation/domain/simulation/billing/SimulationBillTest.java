package com.oracle.construction.aconex.simulation.domain.simulation.billing;

import com.oracle.construction.aconex.simulation.exception.SimulationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimulationBillTest {

    Bill bill;


    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("AddItem Success")
    void addBillItemSuccess() throws SimulationException {
        bill = new SimulationBill();
        bill.addBillItem(new BillItem(Item.FUEL, 2l));
        bill.addBillItem(new BillItem(Item.PENALTY_PROTECTED_TREE, 2l));
        bill.addBillItem(new BillItem(Item.PENALTY_PAINT, 2l));
        bill.addBillItem(new BillItem(Item.UNCLEAR_BLOCK, 2l));
        bill.addBillItem(new BillItem(Item.COMMUNICATION, 2l));
        bill.addBillItem(new BillItem(Item.FUEL, 2l));
    }


    @Test
    void getTotalFromSimulation() throws SimulationException {
        bill = new SimulationBill();
        bill.addBillItem(new BillItem(Item.COMMUNICATION, 7l));
        bill.addBillItem(new BillItem(Item.FUEL, 19l));
        bill.addBillItem(new BillItem(Item.UNCLEAR_BLOCK, 34l));
        bill.addBillItem(new BillItem(Item.PENALTY_PROTECTED_TREE, 0l));
        bill.addBillItem(new BillItem(Item.PENALTY_PAINT, 1l));
        assertEquals(130l, bill.getTotal(), 0.0001);
    }


    @Test
    void getTotalFromSimulationMultipleBillItems() throws SimulationException {
        bill = new SimulationBill();
        bill.addBillItem(new BillItem(Item.COMMUNICATION, 4l));
        bill.addBillItem(new BillItem(Item.COMMUNICATION, 3l));
        bill.addBillItem(new BillItem(Item.FUEL, 10l));
        bill.addBillItem(new BillItem(Item.FUEL, 5l));
        bill.addBillItem(new BillItem(Item.FUEL, 4l));
        bill.addBillItem(new BillItem(Item.UNCLEAR_BLOCK, 10l));
        bill.addBillItem(new BillItem(Item.UNCLEAR_BLOCK, 20l));
        bill.addBillItem(new BillItem(Item.UNCLEAR_BLOCK, 4l));
        bill.addBillItem(new BillItem(Item.PENALTY_PROTECTED_TREE, 0l));
        bill.addBillItem(new BillItem(Item.PENALTY_PAINT, 1l));
        assertEquals(130l, bill.getTotal(), 0.0001);
    }

    @Test
    void getTotalFromAllItensFormSimulation() throws SimulationException {
        bill = new SimulationBill();
        bill.addBillItem(new BillItem(Item.COMMUNICATION, 7l));
        bill.addBillItem(new BillItem(Item.FUEL, 19l));
        bill.addBillItem(new BillItem(Item.UNCLEAR_BLOCK, 34l));
        bill.addBillItem(new BillItem(Item.PENALTY_PROTECTED_TREE, 1l));
        bill.addBillItem(new BillItem(Item.PENALTY_PAINT, 1l));
        assertEquals(140l, bill.getTotal(), 0.0001);
    }

    @Test
    void getBillItemGroupByType() throws SimulationException {
        bill = new SimulationBill();
        bill.addBillItem(new BillItem(Item.COMMUNICATION, 1l));
        bill.addBillItem(new BillItem(Item.COMMUNICATION, 2l));

        bill.addBillItem(new BillItem(Item.FUEL, 19l));
        bill.addBillItem(new BillItem(Item.FUEL, 19l));

        bill.addBillItem(new BillItem(Item.UNCLEAR_BLOCK, 34l));
        bill.addBillItem(new BillItem(Item.UNCLEAR_BLOCK, 34l));

        bill.addBillItem(new BillItem(Item.PENALTY_PROTECTED_TREE, 0l));
        bill.addBillItem(new BillItem(Item.PENALTY_PROTECTED_TREE, 3l));

        bill.addBillItem(new BillItem(Item.PENALTY_PAINT, 1l));
        bill.addBillItem(new BillItem(Item.PENALTY_PAINT, 2l));

        Map<Item, List<BillItem>> groupedBillItems = bill.getBillItemGroupByType();

        assertEquals(5, groupedBillItems.size());

        groupedBillItems.keySet().stream().forEach(
                key -> assertEquals(2, groupedBillItems.get(key).size())
        );
    }
}