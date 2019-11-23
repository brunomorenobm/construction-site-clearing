package com.oracle.construction.aconex.planing.model;

import com.oracle.construction.aconex.planing.model.billing.Bill;
import com.oracle.construction.aconex.planing.model.billing.BillSiteMap;
import com.oracle.construction.aconex.planing.model.map.Command;

import java.util.LinkedList;
import java.util.List;

public class SimulationContext {

    private List<Command> commands;
    private List<String> resultMessage;
    private boolean isExecutionSuspended;
    private CardinalDirection cardinalDirection;
    private Coordinate currentPosition;
    private List<List<Block>> blocks;
    private Bill bill;

    public SimulationContext(List<List<Block>> blocks){
        this.blocks = blocks;
    }

    public void init() {
        this.commands = new LinkedList<>();
        this.resultMessage = new LinkedList<>();
        this.cardinalDirection = cardinalDirection.E;
        this.currentPosition = new Coordinate(1,1);
        this.bill = new BillSiteMap();
    }

    public void addCommand(Command command){
        this.commands.add(command);
    }

    public void setExecutionSuspended(boolean executionSuspended) {
        isExecutionSuspended = executionSuspended;
    }

    public boolean isExecutionSuspended() {
        return isExecutionSuspended;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public CardinalDirection getCardinalDirection() {
        return cardinalDirection;
    }

    public Coordinate getCurrentPosition() {
        return currentPosition;
    }

    public List<String> getResultMessage() {
        return resultMessage;
    }

    public void setCardinalDirection(CardinalDirection cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
    }

    public void setCurrentPosition(Coordinate currentPosition) {
        this.currentPosition = currentPosition;
    }

    public List<List<Block>> getBlocks() {
        return blocks;
    }

    public Bill getBill() {
        return bill;
    }
}
