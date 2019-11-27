package com.oracle.construction.aconex.simulation;

import com.oracle.construction.aconex.simulation.domain.simulation.command.action.Action;
import com.oracle.construction.aconex.simulation.domain.simulation.command.action.BillUnclearBlocksAction;
import com.oracle.construction.aconex.simulation.domain.simulation.command.action.CommandAction;
import com.oracle.construction.aconex.simulation.domain.simulation.command.action.SaveCommandCommandAction;
import com.oracle.construction.aconex.simulation.domain.simulation.map.CleaningSimulation;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.Block;
import com.oracle.construction.aconex.simulation.domain.simulation.map.validation.MapValidation;
import com.oracle.construction.aconex.simulation.domain.simulation.map.validation.BlockedCleanableTreesMapValidation;
import com.oracle.construction.aconex.simulation.domain.simulation.map.validation.UnbalancedMapValidation;
import com.oracle.construction.aconex.simulation.exception.SimulationException;
import com.oracle.construction.aconex.simulation.exception.map.MapSimulationException;
import com.oracle.construction.aconex.simulation.service.repository.BlockRepository;
import com.oracle.construction.aconex.simulation.service.repository.Repository;
import com.oracle.construction.aconex.simulation.view.console.Screen;
import com.oracle.construction.aconex.simulation.view.console.ScreenCommand;
import com.oracle.construction.aconex.simulation.view.console.ScreenSummary;
import com.oracle.construction.aconex.simulation.view.console.ScreenWelcome;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SimulationCleaningConstructionConsole {

    /**
     * Starts the Main Simulation
     * @param fileSourcePath
     * @throws SimulationException
     * @throws MapSimulationException
     */
    public static void startSimulation(String fileSourcePath) throws SimulationException, MapSimulationException {

        Repository<Block> blockRepository = new BlockRepository(fileSourcePath);

        List<CommandAction> executeEveryCommandActions = new LinkedList<>();
        executeEveryCommandActions.add(new SaveCommandCommandAction());


        List<Action> executeBeforeTerminateSimulation = new LinkedList<>();
        executeBeforeTerminateSimulation.add(new BillUnclearBlocksAction());


        List<MapValidation> mapValidation = new LinkedList<>();
        mapValidation.add(new BlockedCleanableTreesMapValidation());
        mapValidation.add(new UnbalancedMapValidation());

        com.oracle.construction.aconex.simulation.domain.simulation.map.Simulation simulation = new CleaningSimulation(blockRepository, executeEveryCommandActions, executeBeforeTerminateSimulation, mapValidation) ;

        List<Screen> screens = new ArrayList<>(3);
        screens.add(new ScreenWelcome(simulation));
        screens.add(new ScreenCommand(simulation));
        screens.add(new ScreenSummary(simulation));

        for (Screen screen : screens){
            screen.show();
        }
    }
}
