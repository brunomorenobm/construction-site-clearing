package com.oracle.construction.aconex.simulation.domain.simulation.command.action;

import com.oracle.construction.aconex.simulation.domain.mock.BlockDataGenerator;
import com.oracle.construction.aconex.simulation.domain.simulation.Context;
import com.oracle.construction.aconex.simulation.domain.simulation.SimulationContext;
import com.oracle.construction.aconex.simulation.domain.simulation.command.Command;
import com.oracle.construction.aconex.simulation.domain.simulation.command.NavigateCommand;
import com.oracle.construction.aconex.simulation.domain.simulation.map.CardinalDirection;
import com.oracle.construction.aconex.simulation.exception.SimulationException;
import com.oracle.construction.aconex.simulation.exception.command.InvalidCommandException;
import com.oracle.construction.aconex.simulation.exception.repository.SimulationRepositoyException;
import com.oracle.construction.aconex.simulation.exception.rules.InterruptSimulationException;
import com.oracle.construction.aconex.simulation.service.repository.BlockRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

class TurnLeftCommandActionTest {

    @Mock
    BlockRepository repository;
    Context context;
    CommandAction commandAction;
    Command command;


    @BeforeEach
    void setUp() throws InvalidCommandException, SimulationRepositoyException {
        MockitoAnnotations.initMocks(this);
        when(repository.findAll()).thenReturn(BlockDataGenerator.simpleBlocks());
        context = new SimulationContext(repository.findAll().get());
        commandAction = new TurnLeftCommandAction();
        command = new NavigateCommand("l");
    }


    @Test
    void turnLeftFromEast() throws InterruptSimulationException, SimulationException {
        context.setCardinalDirection(CardinalDirection.E);
        commandAction.execute(command, context);
        Assertions.assertEquals(CardinalDirection.N, context.getCardinalDirection());
    }

    @Test
    void turnLeftFromSouth() throws InterruptSimulationException, SimulationException {
        context.setCardinalDirection(CardinalDirection.S);
        commandAction.execute(command, context);
        Assertions.assertEquals(CardinalDirection.E, context.getCardinalDirection());
    }

    @Test
    void turnLeftFromWest() throws InterruptSimulationException, SimulationException {
        context.setCardinalDirection(CardinalDirection.W);
        commandAction.execute(command, context);
        Assertions.assertEquals(CardinalDirection.S, context.getCardinalDirection());
    }

    @Test
    void turnLeftFromNorth() throws InterruptSimulationException, SimulationException {
        context.setCardinalDirection(CardinalDirection.N);
        commandAction.execute(command, context);
        Assertions.assertEquals(CardinalDirection.W, context.getCardinalDirection());
    }
}