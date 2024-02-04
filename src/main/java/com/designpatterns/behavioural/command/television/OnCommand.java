package com.design.patterns.behavioural.command.television;

/**
 * concrete class of command
 */
class OnCommand implements Command {

    Television television;

    String name;

    OnCommand(Television television, String name) {
        this.television = television;
        this.name = name;
    }

    @Override
    public void execute() {
        television.on();
    }

    @Override
    public String getName() {
        return this.name;
    }
}