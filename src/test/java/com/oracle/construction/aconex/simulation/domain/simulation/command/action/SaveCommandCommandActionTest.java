package com.oracle.construction.aconex.simulation.domain.simulation.command.action;

import com.oracle.construction.aconex.simulation.domain.mock.BlockDataGenerator;
import com.oracle.construction.aconex.simulation.domain.simulation.Context;
import com.oracle.construction.aconex.simulation.domain.simulation.SimulationContext;
import com.oracle.construction.aconex.simulation.domain.simulation.command.Command;
import com.oracle.construction.aconex.simulation.domain.simulation.command.CommandActionType;
import com.oracle.construction.aconex.simulation.domain.simulation.command.NavigateCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.List;

class SaveCommandCommandActionTest {


    Context context;
    CommandAction action;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        context = new SimulationContext(BlockDataGenerator.simpleBlocks().get());
        context.init();
        action = new SaveCommandCommandAction();

    }

    @Test
    void execute() {


        Assertions.assertDoesNotThrow(() -> action.execute(new NavigateCommand("q"), context));
        Assertions.assertDoesNotThrow(() -> action.execute(new NavigateCommand("r"), context));
        Assertions.assertDoesNotThrow(() -> action.execute(new NavigateCommand("a 20"), context));
        List<Command> commands = context.getCommands();
        Assertions.assertEquals(3, commands.size());
        Assertions.assertEquals(CommandActionType.q, commands.get(0).getCommandAction());
        Assertions.assertEquals(CommandActionType.r, commands.get(1).getCommandAction());
        Assertions.assertEquals(CommandActionType.a, commands.get(2).getCommandAction());
    }
}