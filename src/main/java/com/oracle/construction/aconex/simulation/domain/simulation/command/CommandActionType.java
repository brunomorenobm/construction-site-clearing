package com.oracle.construction.aconex.simulation.domain.simulation.command;

import com.oracle.construction.aconex.simulation.domain.simulation.command.action.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CommandActionType {
    l("turn left", "(l)eft",
            Stream.of(
                    new TurnLeftCommandAction(),
                    new CommunicationRegisterCommandAction()).collect(Collectors.toList())),
    r("turn right", "(r)ight",
            Stream.of(
                    new TurnRightCommandAction(),
                    new CommunicationRegisterCommandAction()).collect(Collectors.toList())),
    a("advance", "(a)dvance <n>",
            Stream.of(
                    new AdvanceCommandAction(),
                    new CommunicationRegisterCommandAction()).collect(Collectors.toList())),
    q("quit", "(q)uit",
            Stream.of(
                    new TerminateCommandAction()).collect(Collectors.toList()));

    private String description;

    private String commandDisplay;

    private List<CommandAction> action;

    CommandActionType(String description, String commandDisplay, List<CommandAction> action) {
        this.description = description;
        this.commandDisplay = commandDisplay;
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public List<CommandAction> getAction() {
        return action;
    }

    public String getCommandDisplay() {
        return commandDisplay;
    }
}
