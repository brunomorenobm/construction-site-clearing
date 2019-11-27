package com.oracle.construction.aconex.simulation.domain.simulation.command;

import com.oracle.construction.aconex.simulation.exception.command.InvalidCommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NavigateCommandTest {

    @BeforeEach
    void setUp() {
    }


    @Test
    void commandQuit() throws InvalidCommandException {
        Command command = new NavigateCommand("q");
        Assertions.assertTrue(command.isValid());
        Assertions.assertEquals(CommandActionType.q, command.getCommandAction());
        Assertions.assertEquals("(q)uit", command.getCommandAction().getCommandDisplay());
        Assertions.assertEquals("quit", command.getCommandAction().getDescription());
    }

    @Test
    void commandLeft() throws InvalidCommandException {
        Command command = new NavigateCommand("l");
        Assertions.assertTrue(command.isValid());
        Assertions.assertEquals(CommandActionType.l, command.getCommandAction());
        Assertions.assertEquals("(l)eft", command.getCommandAction().getCommandDisplay());
        Assertions.assertEquals("turn left", command.getCommandAction().getDescription());
    }

    @Test
    void commandRight() throws InvalidCommandException {
        Command command = new NavigateCommand("r");
        Assertions.assertTrue(command.isValid());
        Assertions.assertEquals(CommandActionType.r, command.getCommandAction());
        Assertions.assertEquals("(r)ight", command.getCommandAction().getCommandDisplay());
        Assertions.assertEquals("turn right", command.getCommandAction().getDescription());
    }

    @Test
    void commandAdvance() throws InvalidCommandException {
        Command command = new NavigateCommand("a 10");
        Assertions.assertTrue(command.isValid());
        Assertions.assertEquals(CommandActionType.a, command.getCommandAction());
        Assertions.assertEquals("(a)dvance <n>", command.getCommandAction().getCommandDisplay());
        Assertions.assertEquals("advance", command.getCommandAction().getDescription());
    }

    @Test
    void invalidCommandAdvance() throws InvalidCommandException {
        Command command = new NavigateCommand("a10");
        Assertions.assertTrue(!command.isValid());
    }

    @Test
    void invalidCommandAdvanceWrongNumber() throws InvalidCommandException {
        Command command = new NavigateCommand("a we");
        Assertions.assertTrue(!command.isValid());
    }


    @Test
    void invalidCommand() throws InvalidCommandException {
        Command command = new NavigateCommand("rfsdf we");
        Assertions.assertTrue(!command.isValid());
    }

}