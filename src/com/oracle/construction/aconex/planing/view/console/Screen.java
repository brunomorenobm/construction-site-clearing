package com.oracle.construction.aconex.planing.view.console;

import java.io.PrintStream;

public interface Screen {
    PrintStream screen = System.out;
    void init();
}
