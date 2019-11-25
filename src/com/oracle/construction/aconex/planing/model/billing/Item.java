package com.oracle.construction.aconex.planing.model.billing;

public enum Item {
    FUEL(1, "fuel usage", new BillItemCalculatorMultiply()), COMMUNICATION(1, "communication overhead", new BillItemCalculatorMultiply()), UNCLEAR_BLOCK(3, "uncleared squares", new BillItemCalculatorMultiply()),
    PENALTY_PROTECTED_TREE(10, "destruction of protected tree", new BillItemCalculatorMultiply()), PENALTY_PAINT(2, "paint damage to bulldozer", new BillItemCalculatorMultiply());

    private double credit;
    private String description;
    private BillItemCalculator calculator;

    Item(int credit, String description, BillItemCalculator calculator) {
        this.credit = credit;
        this.description = description;
        this.calculator = calculator;
    }

    public String getDescription() {
        return description;
    }

    public double getCredit() {
        return credit;
    }

    public BillItemCalculator getCalculator() {
        return calculator;
    }
}
