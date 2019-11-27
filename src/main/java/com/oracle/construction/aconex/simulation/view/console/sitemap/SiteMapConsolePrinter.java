package com.oracle.construction.aconex.simulation.view.console.sitemap;

import com.oracle.construction.aconex.simulation.domain.simulation.map.Simulation;

import java.io.PrintStream;

public interface SiteMapConsolePrinter {

   void print(Simulation simulation, PrintStream out);
}
