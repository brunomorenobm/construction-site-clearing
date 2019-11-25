package com.oracle.construction.aconex.planing.model;

import com.oracle.construction.aconex.planing.model.billing.Bill;
import com.oracle.construction.aconex.planing.model.billing.BillSiteMap;
import com.oracle.construction.aconex.planing.model.simulation.command.Command;
import com.oracle.construction.aconex.planing.model.simulation.map.CardinalDirection;
import com.oracle.construction.aconex.planing.model.simulation.map.Coordinate;
import com.oracle.construction.aconex.planing.model.simulation.map.block.Block;

import java.util.LinkedList;
import java.util.List;

public class SimulationContext implements Context {

    private List<Command> commands;
    private List<String> resultMessage;
    private boolean isExecutionSuspended;
    private CardinalDirection cardinalDirection;
    private Coordinate currentPosition;
    private List<List<Block>>  blocks;
    private Bill bill;

    public SimulationContext(List<List<Block>>  blocks) {
        this.blocks = blocks;
    }

    @Override
    public void init() {
        this.commands = new LinkedList<>();
        this.resultMessage = new LinkedList<>();
        this.bill = new BillSiteMap();

        // RULE 1:
        this.cardinalDirection = cardinalDirection.E;
        this.currentPosition = new Coordinate(-1, 0);

    }

    @Override
    public void addCommand(Command command) {
        this.commands.add(command);
    }

    @Override
    public void setExecutionSuspended(boolean executionSuspended) {
        isExecutionSuspended = executionSuspended;
    }

    @Override
    public boolean isExecutionSuspended() {
        return isExecutionSuspended;
    }

    @Override
    public List<Command> getCommands() {
        return commands;
    }

    @Override
    public CardinalDirection getCardinalDirection() {
        return cardinalDirection;
    }

    @Override
    public Coordinate getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public List<String> getResultMessage() {
        return resultMessage;
    }

    @Override
    public void setCardinalDirection(CardinalDirection cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
    }

    @Override
    public void setCurrentPosition(Coordinate currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public List<List<Block>>  getBlocks() {
        return blocks;
    }

    @Override
    public Bill getBill() {
        return bill;
    }


}
