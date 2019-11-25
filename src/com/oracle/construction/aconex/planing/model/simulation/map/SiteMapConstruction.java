package com.oracle.construction.aconex.planing.model.simulation.map;

import com.oracle.construction.aconex.planing.exception.SimulationException;
import com.oracle.construction.aconex.planing.exception.map.MapSimulationException;
import com.oracle.construction.aconex.planing.exception.map.UnbalancedMapSimulationException;
import com.oracle.construction.aconex.planing.exception.map.UnreachableCleanableBlocksMapSimulationException;
import com.oracle.construction.aconex.planing.exception.repository.SimulationRepositoyException;
import com.oracle.construction.aconex.planing.exception.rules.InterruptSimulationException;
import com.oracle.construction.aconex.planing.model.Context;
import com.oracle.construction.aconex.planing.model.SimulationContext;
import com.oracle.construction.aconex.planing.model.billing.Bill;
import com.oracle.construction.aconex.planing.model.simulation.command.Command;
import com.oracle.construction.aconex.planing.model.simulation.command.action.Action;
import com.oracle.construction.aconex.planing.model.simulation.command.action.CommandAction;
import com.oracle.construction.aconex.planing.model.simulation.map.block.Block;
import com.oracle.construction.aconex.planing.model.simulation.map.validation.MapValidation;
import com.oracle.construction.aconex.planing.service.repository.Repository;

import java.util.List;
import java.util.Optional;


public class SiteMapConstruction implements SiteMap {

    private List<CommandAction> executeEveryCommandActions;
    private List<List<Block>> blocks;
    private Context context;
    private Repository<Block> repository;
    private List<Action> executeBeforeCloseActions;
    private List<MapValidation> mapValidations;


    public SiteMapConstruction(Repository<Block> repository, List<CommandAction> executeEveryCommandActions, List<Action> executeBeforeCloseActions, List<MapValidation> mapValidations) throws SimulationException, SimulationRepositoyException, MapSimulationException {
        this.executeEveryCommandActions = executeEveryCommandActions;
        this.repository = repository;
        this.executeBeforeCloseActions = executeBeforeCloseActions;
        this.mapValidations = mapValidations;
        init();
    }


    public void init() throws SimulationRepositoyException, MapSimulationException {
        load();
        validateMap();
        context = new SimulationContext(this.blocks);
        context.init();

    }

    private void validate() throws MapSimulationException {

    }

    public void load() throws SimulationRepositoyException {
        Optional<List<List<Block>>> blocks = repository.findAll();
        if (blocks.isPresent()) {
            this.blocks = blocks.get();
        }
    }


    @Override
    //TODO: Review Program Flow Try Catch
    public void navigate(Command command) throws SimulationException {

        try {
            if ((command != null) && (command.isValid())) {


                if (executeEveryCommandActions != null) {
                    // TODO: Move Actions Command to Super Class
                    for (CommandAction action : executeEveryCommandActions) {
                        action.execute(command, this.context);
                    }
                }

                // Execute every returned action from Enum
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
    }

    @Override
    public List<List<Block>> getBlocks() {
        return this.blocks;
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
                mapValidation.validate(this.blocks);
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
