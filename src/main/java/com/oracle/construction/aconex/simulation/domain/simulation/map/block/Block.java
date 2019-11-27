package com.oracle.construction.aconex.simulation.domain.simulation.map.block;

import com.oracle.construction.aconex.simulation.exception.SimulationException;
import com.oracle.construction.aconex.simulation.exception.rules.InterruptSimulationException;
import com.oracle.construction.aconex.simulation.domain.simulation.Context;
import com.oracle.construction.aconex.simulation.domain.simulation.map.Coordinate;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.rules.CleaningRule;

import java.util.Optional;

public abstract class Block {

    private Coordinate coordinate;
    private BlockType blockType;
    private int cleanedQuantity = 0;
    private CleaningRule firstCleanRule;
    private CleaningRule secondPass;
    private CleaningRule stopPenalty;
    private CleaningRule passThroughPenalty;

    public Block(BlockType blockType, CleaningRule firstCleanRule, CleaningRule alreadyCleanedPassRule, CleaningRule stopRule, CleaningRule passThroughRule) {
        this.blockType = blockType;
        this.firstCleanRule = firstCleanRule;
        this.secondPass = alreadyCleanedPassRule;
        this.stopPenalty = stopRule;
        this.passThroughPenalty = passThroughRule;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Optional<CleaningRule> getFirstCleanRule() {
        return Optional.ofNullable(firstCleanRule);
    }

    public Optional<CleaningRule> getAlreadyCleanedPassRule() {
        return Optional.ofNullable(secondPass);
    }

    public Optional<CleaningRule> getPassThroughRule() {
        return Optional.ofNullable(passThroughPenalty);
    }

    public Optional<CleaningRule> getStopRule() {
        return Optional.ofNullable(stopPenalty);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public BlockType getBlockType() {
        return blockType;
    }

    public int getCleanedQuantity() {
        return cleanedQuantity;
    }


    public void clean(Context context, Coordinate lastCoordinate) throws InterruptSimulationException, SimulationException {

        // Set current position
        context.setCurrentPosition(this.getCoordinate());



        // Check if it has been cleaned before
        if (this.cleanedQuantity == 0) {
            if (this.getFirstCleanRule().isPresent()){
                // Apply First Clean
                this.getFirstCleanRule().get().apply(context);
            }
        } else {
            if(this.getAlreadyCleanedPassRule().isPresent()) {
                // Apply Revisit Clean
                this.getAlreadyCleanedPassRule().get().apply(context);
            }
        }


        // Add one more Cleaning Execution
        this.cleanedQuantity++;

        // Check if it a "pass through" or a "stop" rule to be applied
        if (!lastCoordinate.equals(this.coordinate)) {
            if(this.getPassThroughRule().isPresent()){
                this.getPassThroughRule().get().apply(context);
            }
        } else {
            if (this.getStopRule().isPresent()){
                this.getStopRule().get().apply(context);
            }
        }


    }

}
