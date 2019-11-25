package com.oracle.construction.aconex.planing.exception.command;

import com.oracle.construction.aconex.planing.exception.SimulationException;
import com.oracle.construction.aconex.planing.model.simulation.command.Command;

public class InvalidCommandException extends SimulationException {

    public InvalidCommandException(String message) {
        super(message);
    }

    public InvalidCommandException(Command command) {
        super("Command is Invalid [" + command.getInputCommand() + "]");
    }

    public InvalidCommandException(String inputCommand, String attribute) {
        super("Command:[" + inputCommand + "] has the Invalid attribute:[" + attribute + "]");
    }
}
