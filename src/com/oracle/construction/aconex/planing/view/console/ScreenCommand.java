package com.oracle.construction.aconex.planing.view.console;

import com.oracle.construction.aconex.planing.exception.InvalidCommandException;
import com.oracle.construction.aconex.planing.model.map.CommandNavigate;
import com.oracle.construction.aconex.planing.model.map.SiteMap;
import com.oracle.construction.aconex.planing.view.console.sitemap.SiteMapConsolePrinterMap;

import java.util.Scanner;

public class ScreenCommand implements Screen {

    SiteMap siteMap;

    public ScreenCommand(SiteMap siteMap){
        this.siteMap = siteMap;
    }

    @Override
    public void init() {
        Scanner in = new Scanner(System.in);
        screen.println("The bulldozer is currently located at the Northern edge of the\n" +
                "site, immediately to the West of the site, and facing East.");

        do {
            screen.println("(l)eft, (r)ight, (a)dvance <n>, (q)uit:");
            String rawCommand = in.nextLine();
            try{
                siteMap.navigate( new CommandNavigate(rawCommand));
                new SiteMapConsolePrinterMap().print(siteMap, screen);

            } catch (InvalidCommandException ex){
                ex.printStackTrace(System.err);
                screen.println("Invalid command " + rawCommand);
            }
        } while (!siteMap.isTerminated());
    }
}
