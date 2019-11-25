package com.oracle.construction.aconex.planing;

import com.oracle.construction.aconex.planing.domain.simulation.command.action.*;
import com.oracle.construction.aconex.planing.domain.simulation.map.SiteMap;
import com.oracle.construction.aconex.planing.domain.simulation.map.SiteMapConstruction;
import com.oracle.construction.aconex.planing.domain.simulation.map.block.Block;
import com.oracle.construction.aconex.planing.domain.simulation.map.validation.MapValidation;
import com.oracle.construction.aconex.planing.domain.simulation.map.validation.MapValidationBlockedCleaneableTrees;
import com.oracle.construction.aconex.planing.domain.simulation.map.validation.MapValidationUnbalanced;
import com.oracle.construction.aconex.planing.service.repository.Repository;
import com.oracle.construction.aconex.planing.service.repository.RepositoryBlock;
import com.oracle.construction.aconex.planing.view.console.Screen;
import com.oracle.construction.aconex.planing.view.console.ScreenCommand;
import com.oracle.construction.aconex.planing.view.console.ScreenSummary;
import com.oracle.construction.aconex.planing.view.console.ScreenWelcome;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.MissingFormatArgumentException;

public class Main {

    public static void main(String[] args) throws Exception {

        String fileSourcePath = null;
        if (args.length == 1){
            fileSourcePath = args[0];
        } else {
            throw new MissingFormatArgumentException("Please inform the site-map path file");
        }

        Repository<Block> blockRepository = new RepositoryBlock(fileSourcePath);

        List<CommandAction> commandActions = new LinkedList<>();
        commandActions.add(new CommandActionSaveCommand());


        List<Action> beforeEndSimulation = new LinkedList<>();
        beforeEndSimulation.add(new ActionUnclearBlocks());


        List<MapValidation> mapValidation = new LinkedList<>();
        mapValidation.add(new MapValidationBlockedCleaneableTrees());
        mapValidation.add(new MapValidationUnbalanced());

        SiteMap siteMap = new SiteMapConstruction(blockRepository, commandActions, beforeEndSimulation, mapValidation) ;

        List<Screen> screens = new ArrayList<>(3);
        screens.add(new ScreenWelcome(siteMap));
        screens.add(new ScreenCommand(siteMap));
        screens.add(new ScreenSummary(siteMap));

        for (Screen screen : screens){
            screen.show();
        }
    }
}
