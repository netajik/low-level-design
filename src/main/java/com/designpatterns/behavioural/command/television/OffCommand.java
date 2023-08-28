package com.designpatterns.behavioural.command.television;

/**
 * concrete class of command
 */
class OffCommand implements Command {

    Television television;
    String name;

    OffCommand(Television television, String name) {
        this.television = television;
        this.name = name;
    }

    @Override
    public void execute() {
        television.off();
    }

    @Override
    public String getName() {
        return this.name;
    }
}