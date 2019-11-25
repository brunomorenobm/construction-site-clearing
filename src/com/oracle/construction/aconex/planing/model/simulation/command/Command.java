package com.oracle.construction.aconex.planing.model.simulation.command;

public interface Command {

    String getInputCommand();

    boolean isValid();

    CommandActionType getCommandAction();

    String getAttribute();

}
