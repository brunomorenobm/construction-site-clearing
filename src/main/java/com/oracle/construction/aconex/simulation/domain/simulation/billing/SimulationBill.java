package com.oracle.construction.aconex.simulation.domain.simulation.billing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

import static java.util.stream.Collectors.groupingByConcurrent;


public class SimulationBill implements Bill {

    List<BillItem> billItems;

    public SimulationBill(){
        this.billItems = new ArrayList<>();
    }

    @Override
    public void addBillItem(BillItem billItem) {
        this.billItems.add(billItem);
    }

    @Override
    public List<BillItem> getBillItems() {
        return this.billItems;
    }

    @Override
    public Double getTotal() {
        return this.billItems.stream().mapToDouble(item -> item.getItem().getCalculator().calculate(item)).sum();
    }

    @Override
    public ConcurrentMap<Item,  List<BillItem>> getBillItemGroupByType() {
        return this.billItems.stream().collect(groupingByConcurrent(BillItem::getItem));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimulationBill)) return false;

        SimulationBill that = (SimulationBill) o;

        return getBillItems() != null ? getBillItems().equals(that.getBillItems()) : that.getBillItems() == null;
    }

    @Override
    public int hashCode() {
        return getBillItems() != null ? getBillItems().hashCode() : 0;
    }
}
