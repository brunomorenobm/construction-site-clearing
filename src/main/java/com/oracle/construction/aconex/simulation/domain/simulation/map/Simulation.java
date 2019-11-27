package com.oracle.construction.aconex.simulation.domain.simulation.map;

import com.oracle.construction.aconex.simulation.exception.SimulationException;
import com.oracle.construction.aconex.simulation.exception.map.MapSimulationException;
import com.oracle.construction.aconex.simulation.exception.repository.SimulationRepositoyException;
import com.oracle.construction.aconex.simulation.domain.simulation.billing.Bill;
import com.oracle.construction.aconex.simulation.domain.simulation.command.Command;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.Block;

import java.util.List;

public interface Simulation {

    void load() throws SimulationRepositoyException;

    void navigate(Command command) throws SimulationException;

    List<List<Block>> getBlocks();

    CardinalDirection getCardinalDirection();

    Coordinate getCurrentPosition();

    void validateMap() throws MapSimulationException;

    List<Command> getExecutedCommands();

    boolean isTerminated();

    void endSimulation() throws SimulationException;

    Bill getBill();

    void init() throws SimulationRepositoyException, MapSimulationException;


}
