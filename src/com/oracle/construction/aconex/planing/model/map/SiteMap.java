package com.oracle.construction.aconex.planing.model.map;

import com.oracle.construction.aconex.planing.model.Block;
import com.oracle.construction.aconex.planing.model.CardinalDirection;
import com.oracle.construction.aconex.planing.model.Coordinate;
import com.oracle.construction.aconex.planing.model.SimulationContext;
import com.oracle.construction.aconex.planing.model.billing.Bill;

import java.util.List;

public interface SiteMap {


    void loadMap(String fileSource) throws Exception;

    void navigate(Command command);

    boolean validateNavigation(Command command);

    List<List<Block>> getSiteMap();

    CardinalDirection getCardinalDirection();

    List<Command> getValidCommands();

    Coordinate getCurrentPosition();

    List<Command> getExecutedCommands();

    boolean isTerminated();

    SimulationContext getContext();

    Bill getBill();
}
