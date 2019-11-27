package com.oracle.construction.aconex.simulation.view.console;

import com.oracle.construction.aconex.simulation.exception.SimulationException;
import com.oracle.construction.aconex.simulation.exception.command.InvalidCommandException;
import com.oracle.construction.aconex.simulation.domain.simulation.command.NavigateCommand;
import com.oracle.construction.aconex.simulation.domain.simulation.map.Simulation;
import com.oracle.construction.aconex.simulation.view.console.sitemap.SiteMapConsolePrinter;
import com.oracle.construction.aconex.simulation.view.console.sitemap.SiteMapConsolePrinterCommandList;
import com.oracle.construction.aconex.simulation.view.console.sitemap.SiteMapConsolePrinterMap;

import java.util.Scanner;

public class ScreenCommand implements Screen {

    Simulation simulation;

    public ScreenCommand(Simulation simulation){
        this.simulation = simulation;
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
            commandList.print(this.simulation, output);
            String rawCommand = in.nextLine();
            try{
                simulation.navigate(new NavigateCommand(rawCommand));
                map.print(simulation, output);

            } catch (InvalidCommandException ex){
                ex.printStackTrace(System.err);
                output.println("Invalid command " + rawCommand);
            } catch (SimulationException ex){
                ex.printStackTrace(System.err);
                output.println("Error execution simulation command: " + rawCommand);
            }
        } while (!simulation.isTerminated());
    }
}
