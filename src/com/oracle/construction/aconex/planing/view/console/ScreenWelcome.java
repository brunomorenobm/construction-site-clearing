package com.oracle.construction.aconex.planing.view.console;


import com.oracle.construction.aconex.planing.model.map.SiteMap;
import com.oracle.construction.aconex.planing.view.console.sitemap.SiteMapConsolePrinterCommands;

public class ScreenWelcome implements Screen {


    SiteMap siteMap;

    public ScreenWelcome(SiteMap siteMap){
        this.siteMap = siteMap;
    }
    @Override
    public void init() {
        screen.println("Welcome to the Aconex site clearing simulator. This is a map of\n" +
                "the site:");
        new SiteMapConsolePrinterCommands().print(this.siteMap, screen);

    }
}
