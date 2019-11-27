package com.oracle.construction.aconex.simulation.view.console;

import com.oracle.construction.aconex.simulation.domain.simulation.map.Simulation;
import com.oracle.construction.aconex.simulation.view.console.sitemap.SiteMapConsolePrinterBill;
import com.oracle.construction.aconex.simulation.view.console.sitemap.SiteMapConsolePrinterExecutedCommands;

public class ScreenSummary implements Screen {

    Simulation simulation;

    public ScreenSummary(Simulation simulation) {
        this.simulation = simulation;
    }

    @Override
    public void show() {
        output.println("The simulation has ended at your request. These are the commands\n" +
                "you issued:");

        new SiteMapConsolePrinterExecutedCommands().print(this.simulation, output);

        output.println("The costs for this land clearing operation were:");

        new SiteMapConsolePrinterBill().print(this.simulation, output);

        output.println("\nThank you for using the Aconex site clearing simulator.");

    }
}
