package com.oracle.construction.aconex.planing.view.console.sitemap;

import com.oracle.construction.aconex.planing.model.Block;
import com.oracle.construction.aconex.planing.model.Coordinate;
import com.oracle.construction.aconex.planing.model.map.SiteMap;

import java.io.PrintStream;
import java.util.List;

public class SiteMapConsolePrinterMap implements SiteMapConsolePrinter {

    public static final String GREEN = "\033[0;32m";
    public static final String RESET = "\033[0m";

    @Override
    public void print(SiteMap siteMap, PrintStream out) {
        Coordinate position = siteMap.getCurrentPosition();
        boolean positionPrinted = false;
        out.printf("Current position column: %d, row: %d\n", siteMap.getCurrentPosition().getColumn(), siteMap.getCurrentPosition().getRow());

        out.printf("Pointing direction to: %s %s \n", siteMap.getCardinalDirection().name(), siteMap.getCardinalDirection().getCharacter());

        for (List<Block> rows : siteMap.getSiteMap()) {
            for (Block block : rows) {
                block.getBlockType().name();

                if (positionPrinted && position.equals(block.getCoordinate())) {
                    out.printf("%s %s %s", GREEN, block.getBlockType().name(), RESET);
                } else {
                    out.print(block.getBlockType().name());
                }
            }
            out.print("\n");
        }

    }


}
