package com.oracle.construction.aconex.simulation.domain.simulation.billing;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

public interface Bill {

    List<BillItem> getBillItems();

    ConcurrentMap<Item, List<BillItem>> getBillItemGroupByType();

    Double getTotal();

    void addBillItem(BillItem billItem);

}
