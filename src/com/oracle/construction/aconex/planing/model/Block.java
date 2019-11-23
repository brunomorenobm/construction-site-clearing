package com.oracle.construction.aconex.planing.model;

import java.util.List;

public class Block {

    Coordinate coordinate;
    BlockType blockType;
    int qntExecuted = 0;

    public Block(Coordinate coordinate, BlockType blockType) {
        this.coordinate = coordinate;
        this.blockType = blockType;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public BlockType getBlockType() {
        return blockType;
    }


    public void clean(List<Coordinate> coordinates, SimulationContext context){
        // Clean Rules
        if (this.qntExecuted == 0){
            this.getBlockType().getRuleSet().getFirstPassCost().apply(context);
        } else {
            this.getBlockType().getRuleSet().getSecondCost().apply(context);
        }

        // Penalty Rules - Pass through
        Coordinate lastCoordinate = coordinates.get(coordinates.size() - 1);
        if (!this.getCoordinate().equals(lastCoordinate)){
            this.getBlockType().getRuleSet().getPassThroughPelanty().apply(context);
        }

        this.qntExecuted ++;
    }
}
