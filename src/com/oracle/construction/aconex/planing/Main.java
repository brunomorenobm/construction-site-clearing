package com.oracle.construction.aconex.planing;

import com.oracle.construction.aconex.planing.model.map.action.Action;
import com.oracle.construction.aconex.planing.model.map.SiteMap;
import com.oracle.construction.aconex.planing.model.map.action.ActionSaveCommand;
import com.oracle.construction.aconex.planing.model.map.SiteMapConstruction;
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
        List<Action> actions = new LinkedList<>();
        actions.add(new ActionSaveCommand());

        SiteMap siteMap = new SiteMapConstruction(fileSourcePath, actions) ;

        List<Screen> screens = new ArrayList<>(3);
        screens.add(new ScreenWelcome(siteMap));
        screens.add(new ScreenCommand(siteMap));
        screens.add(new ScreenSummary(siteMap));

        for (Screen screen : screens){
            screen.init();
        }
    }
}
