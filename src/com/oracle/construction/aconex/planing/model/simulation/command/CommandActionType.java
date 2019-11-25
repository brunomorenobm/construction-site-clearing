package com.oracle.construction.aconex.planing.model.simulation.command;

import com.oracle.construction.aconex.planing.model.simulation.command.action.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CommandActionType {
    l("turn left",
            Stream.of(
                    new CommandActionTurnLeft(),
                    new CommandActionCommunicationRegister()).collect(Collectors.toList())),
    r("turn right",
            Stream.of(
                    new CommandActionTurnRight(),
                    new CommandActionCommunicationRegister()).collect(Collectors.toList())),
    q("quit",
            Stream.of(
                    new CommandActionTerminate()).collect(Collectors.toList())),
    a("advance",
            Stream.of(
                    new CommandActionAdvance(),
                    new CommandActionCommunicationRegister()).collect(Collectors.toList()));

    private String description;

    private List<CommandAction> action;

    CommandActionType(String description, List<CommandAction> action) {
        this.description = description;
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public List<CommandAction> getAction() {
        return action;
    }
}
