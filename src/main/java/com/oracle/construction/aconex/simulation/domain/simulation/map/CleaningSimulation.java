package com.oracle.construction.aconex.simulation.domain.simulation.map;

import com.oracle.construction.aconex.simulation.exception.SimulationException;
import com.oracle.construction.aconex.simulation.exception.map.MapSimulationException;
import com.oracle.construction.aconex.simulation.exception.repository.SimulationRepositoyException;
import com.oracle.construction.aconex.simulation.exception.rules.InterruptSimulationException;
import com.oracle.construction.aconex.simulation.domain.simulation.Context;
import com.oracle.construction.aconex.simulation.domain.simulation.SimulationContext;
import com.oracle.construction.aconex.simulation.domain.simulation.billing.Bill;
import com.oracle.construction.aconex.simulation.domain.simulation.command.Command;
import com.oracle.construction.aconex.simulation.domain.simulation.command.action.Action;
import com.oracle.construction.aconex.simulation.domain.simulation.command.action.CommandAction;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.Block;
import com.oracle.construction.aconex.simulation.domain.simulation.map.validation.MapValidation;
import com.oracle.construction.aconex.simulation.service.repository.Repository;

import java.util.List;
import java.util.Optional;


public class CleaningSimulation implements Simulation {

    private List<CommandAction> executeEveryCommandActions;
    private Context context;
    private Repository<Block> repository;
    private List<Action> executeBeforeCloseActions;
    private List<MapValidation> mapValidations;


    public CleaningSimulation(Repository<Block> repository, List<CommandAction> executeEveryCommandActions, List<Action> executeBeforeCloseActions, List<MapValidation> mapValidations) throws SimulationException, SimulationRepositoyException, MapSimulationException {
        this.executeEveryCommandActions = executeEveryCommandActions;
        this.repository = repository;
        this.executeBeforeCloseActions = executeBeforeCloseActions;
        this.mapValidations = mapValidations;
        init();
    }

    @Override
    public void init() throws SimulationRepositoyException, MapSimulationException {
        load();
        validateMap();
        context.init();

    }

    @Override
    public void load() throws SimulationRepositoyException {
        Optional<List<List<Block>>> blocks = repository.findAll();
        if (blocks.isPresent()) {
            context = new SimulationContext(blocks.get());
        }
    }


    @Override
    public void navigate(Command command) throws SimulationException {
        try {
            if ((command != null) && (command.isValid())) {

                // Executes the action associated ate the Simulation Creation
                if (executeEveryCommandActions != null) {
                    for (CommandAction action : executeEveryCommandActions) {
                        action.execute(command, this.context);
                    }
                }

                // Execute all actions associated with the Enum
                for (CommandAction commandAction : command.getCommandAction().getAction()) {
                    commandAction.execute(command, this.context);
                }
            }
        } catch (InterruptSimulationException ex) {
            context.setExecutionSuspended(true);
        }

        if (context.isExecutionSuspended()) {
            this.endSimulation();
        }

    }

    public void endSimulation() throws SimulationException {
        if (this.executeBeforeCloseActions != null) {
            for (Action action : this.executeBeforeCloseActions) {
                action.execute(context);
            }
        }
        this.context.setExecutionSuspended(true);
    }

    @Override
    public List<List<Block>> getBlocks() {
        return this.context.getBlocks();
    }

    @Override
    public CardinalDirection getCardinalDirection() {
        return this.context.getCardinalDirection();
    }

    @Override
    public Coordinate getCurrentPosition() {
        return this.context.getCurrentPosition();
    }

    @Override
    public void validateMap() throws MapSimulationException {
        if (this.mapValidations != null) {
            for (MapValidation mapValidation : this.mapValidations) {
                mapValidation.validate(this.context.getBlocks());
            }
        }
    }

    @Override
    public List<Command> getExecutedCommands() {
        return this.context.getCommands();
    }

    @Override
    public boolean isTerminated() {
        return this.context.isExecutionSuspended();
    }

    @Override
    public Bill getBill() {
        return this.context.getBill();
    }


}
