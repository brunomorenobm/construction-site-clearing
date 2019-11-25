package com.oracle.construction.aconex.planing.domain.billing;

public class BillItem {

    private Item item;

    private Long quantity;

    public BillItem(Item item, Long quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public Long getQuantity() {
        return quantity;
    }
}
