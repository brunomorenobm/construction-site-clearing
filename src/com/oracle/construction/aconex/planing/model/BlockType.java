package com.oracle.construction.aconex.planing.model;


import com.oracle.construction.aconex.planing.service.impl.CleaningRuleSet;
import com.oracle.construction.aconex.planing.service.impl.ScratchPenalty;
import com.oracle.construction.aconex.planing.service.impl.SimpleCharge;

public enum BlockType {

    // Clean Area
    o(new CleaningRuleSet(
            new SimpleCharge(),
            new SimpleCharge(),
            new ScratchPenalty(),
            new ScratchPenalty()
    )),
    //Rocky
    r(new CleaningRuleSet(
            new SimpleCharge(),
            new SimpleCharge(),
            new ScratchPenalty(),
            new ScratchPenalty()
    )),
    // Trees
    t(new CleaningRuleSet(
            new SimpleCharge(),
            new SimpleCharge(),
            new ScratchPenalty(),
            new ScratchPenalty()
    )),
    // Preserved Trees
    T(new CleaningRuleSet(
            new SimpleCharge(),
            new SimpleCharge(),
            new ScratchPenalty(),
            new ScratchPenalty()
    ));

    private CleaningRuleSet ruleSet;


    BlockType(CleaningRuleSet ruleSet) {
        this.ruleSet = ruleSet;
    }

    public CleaningRuleSet getRuleSet() {
        return ruleSet;
    }

}
