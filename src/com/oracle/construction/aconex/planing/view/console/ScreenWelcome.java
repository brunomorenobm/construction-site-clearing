package com.oracle.construction.aconex.planing.view.console;


import com.oracle.construction.aconex.planing.model.simulation.map.SiteMap;
import com.oracle.construction.aconex.planing.view.console.sitemap.SiteMapConsolePrinterCommands;
import com.oracle.construction.aconex.planing.view.console.sitemap.SiteMapConsolePrinterMap;

public class ScreenWelcome implements Screen {


    SiteMap siteMap;

    public ScreenWelcome(SiteMap siteMap){
        this.siteMap = siteMap;
    }
    @Override
    public void show() {
        output.println("Welcome to the Aconex site clearing simulator. This is a map of\n" +
                "the site:");
        new SiteMapConsolePrinterMap().print(this.siteMap, output);

    }
}
