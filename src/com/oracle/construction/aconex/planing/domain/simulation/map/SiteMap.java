package com.oracle.construction.aconex.planing.domain.simulation.map;

import com.oracle.construction.aconex.planing.exception.SimulationException;
import com.oracle.construction.aconex.planing.exception.map.MapSimulationException;
import com.oracle.construction.aconex.planing.exception.repository.SimulationRepositoyException;
import com.oracle.construction.aconex.planing.domain.billing.Bill;
import com.oracle.construction.aconex.planing.domain.simulation.command.Command;
import com.oracle.construction.aconex.planing.domain.simulation.map.block.Block;

import java.util.List;

public interface SiteMap {

    void load() throws SimulationRepositoyException;

    void navigate(Command command) throws SimulationException;

    List<List<Block>> getBlocks();

    CardinalDirection getCardinalDirection();

    Coordinate getCurrentPosition();

    void validateMap() throws MapSimulationException;

    // TODO: Move to Simulation
    List<Command> getExecutedCommands();

    boolean isTerminated();

    void endSimulation() throws SimulationException;

    Bill getBill();


}
