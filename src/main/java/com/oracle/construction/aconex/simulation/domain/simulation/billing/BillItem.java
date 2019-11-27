package com.oracle.construction.aconex.simulation.domain.simulation.billing;

import com.oracle.construction.aconex.simulation.exception.SimulationException;

public class BillItem {

    private Item item;

    private Long quantity;

    public BillItem(Item item, Long quantity) throws SimulationException {
        if ((quantity == null) || (quantity < 0) || (item == null)) {
            throw new SimulationException("Invalid billing quantity");
        }
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public Long getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BillItem)) return false;

        BillItem billItem = (BillItem) o;

        if (getItem() != billItem.getItem()) return false;
        return getQuantity().equals(billItem.getQuantity());
    }

    @Override
    public int hashCode() {
        int result = getItem().hashCode();
        result = 31 * result + getQuantity().hashCode();
        return result;
    }
}
