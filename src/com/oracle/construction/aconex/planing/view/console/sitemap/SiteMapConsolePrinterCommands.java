package com.oracle.construction.aconex.planing.view.console.sitemap;

import com.oracle.construction.aconex.planing.model.map.SiteMap;

import java.io.PrintStream;
import java.util.stream.Collectors;

public class SiteMapConsolePrinterCommands implements SiteMapConsolePrinter {

    public void print(SiteMap siteMap, PrintStream out) {
        String strCommands = siteMap.getExecutedCommands().stream().map(command -> command.toString())
                .collect(Collectors.joining(", "));
        out.println(strCommands);
    }
}
