package com.oracle.construction.aconex.simulation.view.console;

import java.io.PrintStream;

public interface Screen {
    PrintStream output = System.out;
    void show();
}
