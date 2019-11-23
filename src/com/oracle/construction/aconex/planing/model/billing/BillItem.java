package com.oracle.construction.aconex.planing.model.billing;

public class BillItem {

    private Item item;

    private Integer quantity;

    public BillItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
