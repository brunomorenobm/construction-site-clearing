package com.oracle.construction.aconex.planing.model.map;

import com.oracle.construction.aconex.planing.exception.InvalidCommandException;
import com.oracle.construction.aconex.planing.model.map.action.CommandAction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandNavigate implements Command {

    final String REGEX_VALIDATE_COMMAND = "^(?<command>[a-z]{1})((\\s)(?<attribute>\\d+))?$";
    final Pattern commandPattern = Pattern.compile(REGEX_VALIDATE_COMMAND);

    String inputCommand;
    CommandAction commandAction;
    String attribute;

    public CommandNavigate(String command) throws InvalidCommandException {
        this.inputCommand = command;
        parseCommand(command);
    }

    private void parseCommand(String command) throws InvalidCommandException {
        if (isValid()) {
            Matcher commandMatcher = commandPattern.matcher(command);
            commandMatcher.find();
            try {
                this.commandAction = CommandAction.valueOf(commandMatcher.group("command"));
            } catch (Exception e) {
                throw new InvalidCommandException("Invalid inputCommand: " + command);
            }

            if (commandMatcher.group("attribute") != null) {
                attribute = commandMatcher.group("attribute");
            }
        }
    }

    @Override
    public String getInputCommand() {
        return this.inputCommand;
    }

    @Override
    public boolean isValid() {
        return (this.inputCommand != null)
                && (!this.inputCommand.isEmpty())
                && this.inputCommand.matches(REGEX_VALIDATE_COMMAND);
    }

    @Override
    public String getAttribute() {
        return attribute;
    }

    @Override
    public CommandAction getCommandAction() {
        return commandAction;
    }

    public String toString() {
        return this.getCommandAction().getDescription() + (attribute != null ? " " + attribute : "");
    }

    @Override
    public boolean isTerminateCommand() {
        return inputCommand.equals(CommandAction.q);
    }
}
