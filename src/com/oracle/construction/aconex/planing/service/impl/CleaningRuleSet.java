package com.oracle.construction.aconex.planing.service.impl;

import com.oracle.construction.aconex.planing.service.rules.BreakRule;
import com.oracle.construction.aconex.planing.service.rules.ConsumeRule;
import com.oracle.construction.aconex.planing.service.rules.PenaltyRule;
import com.oracle.construction.aconex.planing.service.rules.RuleSet;

public class CleaningRuleSet implements RuleSet {

    private ConsumeRule firstPassCost;
    private ConsumeRule secondCost;
    private PenaltyRule stopRulePenalty;
    private PenaltyRule passThroughPelanty;
    private BreakRule breakRule;

    public CleaningRuleSet(ConsumeRule firstPassCost, ConsumeRule secondCost, PenaltyRule stopRulePenalty, PenaltyRule passThroughPelanty) {
        this.firstPassCost = firstPassCost;
        this.secondCost = secondCost;
        this.stopRulePenalty = stopRulePenalty;
        this.passThroughPelanty = passThroughPelanty;
    }

    public ConsumeRule getFirstPassCost() {
        return firstPassCost;
    }

    public ConsumeRule getSecondCost() {
        return secondCost;
    }

    public PenaltyRule getPassThroughPelanty() {
        return passThroughPelanty;
    }

    public PenaltyRule getStopRulePenalty() {
        return stopRulePenalty;
    }

    public BreakRule getBreakRule() {
        return breakRule;
    }
}
