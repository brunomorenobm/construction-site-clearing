package com.oracle.construction.aconex.simulation.domain.simulation;

import com.oracle.construction.aconex.simulation.domain.simulation.billing.Bill;
import com.oracle.construction.aconex.simulation.domain.simulation.billing.SimulationBill;
import com.oracle.construction.aconex.simulation.domain.simulation.command.Command;
import com.oracle.construction.aconex.simulation.domain.simulation.map.CardinalDirection;
import com.oracle.construction.aconex.simulation.domain.simulation.map.Coordinate;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.Block;

import java.util.LinkedList;
import java.util.List;

public class SimulationContext implements Context {

    private List<Command> commands;
    private List<String> resultMessage;
    private boolean isExecutionSuspended;
    private CardinalDirection cardinalDirection = CardinalDirection.E;
    private Coordinate initialPosition;
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
        this.bill = new SimulationBill();

        // RULE 1:
        this.cardinalDirection = cardinalDirection.E;
        this.initialPosition = new Coordinate(-1, 0);
        this.currentPosition = getInitialPosition();
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

    @Override
    public Coordinate getInitialPosition() {
        return this.initialPosition;
    }

}
