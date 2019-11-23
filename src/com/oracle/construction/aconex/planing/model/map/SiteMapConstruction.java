package com.oracle.construction.aconex.planing.model.map;

import com.oracle.construction.aconex.planing.model.*;
import com.oracle.construction.aconex.planing.model.billing.Bill;
import com.oracle.construction.aconex.planing.service.impl.FileRead;
import com.oracle.construction.aconex.planing.model.map.action.Action;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class SiteMapConstruction implements SiteMap {


    private List<Action> actions;
    private List<List<Block>> blocks;
    private SimulationContext simulationContext;


    public SiteMapConstruction(String fileSource, List<Action> actions) throws Exception {
        loadMap(fileSource);
        this.simulationContext = new SimulationContext(this.getSiteMap());
        this.actions = actions;
        init();
    }


    public void init(){
        simulationContext.init();
    }

    @Override
    public void loadMap(String fileSource) throws Exception{
        //TODO: Remove it form here it is Infra and DAO move to the next Repo Layer
        AtomicInteger index = new AtomicInteger();
        this.blocks = FileRead.readFile(fileSource).map(line -> parseLine(index.getAndIncrement(), line)).collect(Collectors.toList());
    }

    private List<Block> parseLine (int rowIndex, String line){
        List<Block> row = new Vector();
        AtomicInteger index = new AtomicInteger();
        for (char character : line.toCharArray()){

            // Create a new coordinate object to query the position of the block
            Coordinate coordinate = new Coordinate(rowIndex, index.getAndIncrement());

            // Sets the block Type, encapsulated with all rules
            BlockType blockType = BlockType.valueOf(String.valueOf(character));

            // Add new Block to the map
            row.add(new Block(coordinate, blockType));
        }
        return row;
    }

    @Override
    public void navigate(Command command) {
        if (actions != null){
            //TODO: Change to command.execute()
            command.getCommandAction().getAction().execute(command, this.simulationContext);
            // TODO: Move Actions Command to Super Class
            for (Action action: actions){
                action.execute(command, this.simulationContext);
            }
        }
    }

    @Override
    public boolean validateNavigation(Command command) {
        return false;
    }

    @Override
    public List<List<Block>> getSiteMap() {
        return this.blocks;
    }

    @Override
    public CardinalDirection getCardinalDirection() {
        return this.simulationContext.getCardinalDirection();
    }

    @Override
    public List<Command> getValidCommands() {
        return null;
    }

    @Override
    public Coordinate getCurrentPosition() {
        return this.simulationContext.getCurrentPosition();
    }

    @Override
    public List<Command> getExecutedCommands() {
        return this.simulationContext.getCommands();
    }

    @Override
    public boolean isTerminated() {
        return this.simulationContext.isExecutionSuspended();
    }

    @Override
    public Bill getBill() {
        return this.getContext().getBill();
    }

    @Override
    public SimulationContext getContext() {
        return this.simulationContext;
    }
}
