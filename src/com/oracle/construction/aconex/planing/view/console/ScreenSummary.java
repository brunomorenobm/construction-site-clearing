package com.oracle.construction.aconex.planing.view.console;

import com.oracle.construction.aconex.planing.model.map.SiteMap;
import com.oracle.construction.aconex.planing.view.console.sitemap.SiteMapConsolePrinterBill;
import com.oracle.construction.aconex.planing.view.console.sitemap.SiteMapConsolePrinterCommands;

public class ScreenSummary implements Screen {

    SiteMap siteMap;

    public ScreenSummary(SiteMap siteMap) {
        this.siteMap = siteMap;
    }

    @Override
    public void init() {
        screen.println("The simulation has ended at your request. These are the commands\n" +
                "you issued:");

        new SiteMapConsolePrinterCommands().print(this.siteMap, screen);

        screen.println("The costs for this land clearing operation were:");

        new SiteMapConsolePrinterBill().print(this.siteMap, screen);

        screen.println("\nThank you for using the Aconex site clearing simulator.");

    }
}
