package com.oracle.construction.aconex.planing.view.console;

import com.oracle.construction.aconex.planing.exception.SimulationException;
import com.oracle.construction.aconex.planing.exception.command.InvalidCommandException;
import com.oracle.construction.aconex.planing.domain.simulation.command.CommandNavigate;
import com.oracle.construction.aconex.planing.domain.simulation.map.SiteMap;
import com.oracle.construction.aconex.planing.view.console.sitemap.SiteMapConsolePrinter;
import com.oracle.construction.aconex.planing.view.console.sitemap.SiteMapConsolePrinterCommandList;
import com.oracle.construction.aconex.planing.view.console.sitemap.SiteMapConsolePrinterMap;

import java.util.Scanner;

public class ScreenCommand implements Screen {

    SiteMap siteMap;

    public ScreenCommand(SiteMap siteMap){
        this.siteMap = siteMap;
    }

    /**
     * RULE 8: Commands may be abbreviated to their first letter. Commands will be executed whenever the "Enter" key is pressed
     */
    @Override
    public void show() {
        Scanner in = new Scanner(System.in);
        output.println("The bulldozer is currently located at the Northern edge of the\n" +
                "site, immediately to the West of the site, and facing East.");

        SiteMapConsolePrinter map = new SiteMapConsolePrinterMap();
        SiteMapConsolePrinter commandList = new SiteMapConsolePrinterCommandList();
        do {
            commandList.print(this.siteMap, output);
            String rawCommand = in.nextLine();
            try{
                siteMap.navigate(new CommandNavigate(rawCommand));
                map.print(siteMap, output);

            } catch (InvalidCommandException ex){
                ex.printStackTrace(System.err);
                output.println("Invalid command " + rawCommand);
            } catch (SimulationException ex){
                ex.printStackTrace(System.err);
                output.println("Error execution simulation command: " + rawCommand);
            }
        } while (!siteMap.isTerminated());
    }
}
