package com.oracle.construction.aconex.planing.domain.billing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

import static java.util.stream.Collectors.groupingByConcurrent;


public class BillSiteMap implements Bill {

    List<BillItem> billItems;

    public BillSiteMap(){
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
}
