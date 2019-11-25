package com.oracle.construction.aconex.planing.model;

import com.oracle.construction.aconex.planing.model.billing.Bill;
import com.oracle.construction.aconex.planing.model.simulation.command.Command;
import com.oracle.construction.aconex.planing.model.simulation.map.CardinalDirection;
import com.oracle.construction.aconex.planing.model.simulation.map.Coordinate;
import com.oracle.construction.aconex.planing.model.simulation.map.block.Block;

import java.util.List;

public interface Context {
    void init();

    void addCommand(Command command);

    void setExecutionSuspended(boolean executionSuspended);

    boolean isExecutionSuspended();

    List<Command> getCommands();

    CardinalDirection getCardinalDirection();

    Coordinate getCurrentPosition();

    List<String> getResultMessage();

    void setCardinalDirection(CardinalDirection cardinalDirection);

    void setCurrentPosition(Coordinate currentPosition);

    List<List<Block>>  getBlocks();

    Bill getBill();
}