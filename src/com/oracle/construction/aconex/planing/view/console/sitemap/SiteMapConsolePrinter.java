package com.oracle.construction.aconex.planing.view.console.sitemap;

import com.oracle.construction.aconex.planing.model.simulation.map.SiteMap;

import java.io.PrintStream;

public interface SiteMapConsolePrinter {

   void print(SiteMap siteMap, PrintStream out);
}
