package com.oracle.construction.aconex.simulation.view.console;


import com.oracle.construction.aconex.simulation.domain.simulation.map.Simulation;
import com.oracle.construction.aconex.simulation.view.console.sitemap.SiteMapConsolePrinterMap;

public class ScreenWelcome implements Screen {


    Simulation simulation;

    public ScreenWelcome(Simulation simulation){
        this.simulation = simulation;
    }
    @Override
    public void show() {
        output.println("Welcome to the Aconex site clearing simulator. This is a map of\n" +
                "the site:");
        new SiteMapConsolePrinterMap().print(this.simulation, output);

    }
}
