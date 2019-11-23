package com.oracle.construction.aconex.planing.model.map;

import com.oracle.construction.aconex.planing.model.map.action.CommandAction;

public interface Command {

    String getInputCommand();

    boolean isValid();

    boolean isTerminateCommand();

    CommandAction getCommandAction();

    String getAttribute();

}
