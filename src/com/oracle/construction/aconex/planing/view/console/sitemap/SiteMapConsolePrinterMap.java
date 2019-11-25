package com.oracle.construction.aconex.planing.view.console.sitemap;

import com.oracle.construction.aconex.planing.domain.simulation.map.Coordinate;
import com.oracle.construction.aconex.planing.domain.simulation.map.SiteMap;
import com.oracle.construction.aconex.planing.domain.simulation.map.block.Block;

import java.io.PrintStream;
import java.util.List;

public class SiteMapConsolePrinterMap implements SiteMapConsolePrinter {

    public static final String GREEN = "\033[1;30m";
    public static final String LIGHT_GREEN = "\033[1;32m";
    public static final String RESET = "\033[0m";

    @Override
    public void print(SiteMap siteMap, PrintStream out) {
        Coordinate position = siteMap.getCurrentPosition();
        out.printf("Current position column: %d, row: %d\n", siteMap.getCurrentPosition().getColumn(), siteMap.getCurrentPosition().getRow());

        out.printf("Pointing direction to: %s %s \n", siteMap.getCardinalDirection().name(), siteMap.getCardinalDirection().getCharacter());

        for (List<Block> rows : siteMap.getBlocks()) {
            for (Block block : rows) {
                block.getBlockType().name();

                if (block.getCleanedQuantity() > 0 && position.equals(block.getCoordinate())) {
                    out.printf("%s%s%s", GREEN, block.getBlockType().name(), RESET);
                } else if (block.getCleanedQuantity() > 0) {
                    out.printf("%s%s%s", LIGHT_GREEN, block.getBlockType().name(), RESET);
                } else {
                    out.print(block.getBlockType().name());
                }
            }
            out.print("\n");
        }

    }


}
