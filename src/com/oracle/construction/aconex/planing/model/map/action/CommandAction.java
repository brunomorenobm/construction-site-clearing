package com.oracle.construction.aconex.planing.model.map.action;

public enum CommandAction {
    l("turn left", new ActionTurnLeft()),
    r("turn right", new ActionTurnRight()),
    q("quit", new ActionTerminateNavigate()),
    a("advance", new ActionAdvance());

    private String description;

    private Action action;

    CommandAction(String description, Action action){
        this.description = description;
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public Action getAction() {
        return action;
    }
}
