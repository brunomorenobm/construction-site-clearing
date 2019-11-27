package com.oracle.construction.aconex.simulation.domain.simulation.map;

import com.oracle.construction.aconex.simulation.domain.mock.BlockDataGenerator;
import com.oracle.construction.aconex.simulation.domain.simulation.command.NavigateCommand;
import com.oracle.construction.aconex.simulation.domain.simulation.command.action.Action;
import com.oracle.construction.aconex.simulation.domain.simulation.command.action.BillUnclearBlocksAction;
import com.oracle.construction.aconex.simulation.domain.simulation.command.action.CommandAction;
import com.oracle.construction.aconex.simulation.domain.simulation.command.action.SaveCommandCommandAction;
import com.oracle.construction.aconex.simulation.domain.simulation.map.validation.MapValidation;
import com.oracle.construction.aconex.simulation.domain.simulation.map.validation.BlockedCleanableTreesMapValidation;
import com.oracle.construction.aconex.simulation.domain.simulation.map.validation.UnbalancedMapValidation;
import com.oracle.construction.aconex.simulation.exception.SimulationException;
import com.oracle.construction.aconex.simulation.exception.map.MapSimulationException;
import com.oracle.construction.aconex.simulation.service.repository.BlockRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

class CleaningSimulationTest {

    @Mock
    BlockRepository repository;

    List<MapValidation> validations;

    Simulation simulation;

    List<CommandAction> commandActions;

    List<Action> postExecutionActions;

    @BeforeEach
    void setUp() throws SimulationException, MapSimulationException {
        MockitoAnnotations.initMocks(this);
        when(repository.findAll()).thenReturn(BlockDataGenerator.complexBlocks());
        validations = Stream.of(new UnbalancedMapValidation(), new BlockedCleanableTreesMapValidation()).collect(Collectors.toList());
        commandActions = Stream.of(new SaveCommandCommandAction()).collect(Collectors.toList());
        postExecutionActions = Stream.of(new BillUnclearBlocksAction()).collect(Collectors.toList());
        simulation = new CleaningSimulation(repository, commandActions, postExecutionActions, validations);
    }

    @Test
    void load() {
        Assertions.assertDoesNotThrow(() -> simulation.load());
    }

    @Test
    void init() {
        Assertions.assertDoesNotThrow(() -> simulation.init());
    }


    @Test
    void navigate() throws SimulationException {
        Assertions.assertDoesNotThrow(() -> simulation.init());
        List<String> commands = Stream.of("a 4", "r", "a 4", "l", "a 2", "a 4", "l", "q").collect(Collectors.toList());

        // Execute Commands
        for (String strCommand : commands) {
            simulation.navigate(new NavigateCommand(strCommand));
        }

        Assertions.assertEquals(130d, simulation.getBill().getTotal());
        Assertions.assertEquals(true, simulation.isTerminated());
    }

    @Test
    void navigateProtectedTree() {
        Assertions.assertDoesNotThrow(() -> simulation.init());
        List<String> commands = Stream.of("a 8", "r", "a 1").collect(Collectors.toList());

        // Execute Commands
        for (String strCommand : commands) {
            Assertions.assertDoesNotThrow(() -> simulation.navigate(new NavigateCommand(strCommand)));
        }

        Assertions.assertEquals(143d, simulation.getBill().getTotal());
        Assertions.assertEquals(true, simulation.isTerminated());
    }

}