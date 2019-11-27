package com.oracle.construction.aconex.simulation.domain.simulation.command;

public interface Command {

    String getInputCommand();

    boolean isValid();

    CommandActionType getCommandAction();

    String getAttribute();

}
