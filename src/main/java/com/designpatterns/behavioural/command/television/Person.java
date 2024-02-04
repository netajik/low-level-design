package com.design.patterns.behavioural.command.television;

/**
 * client class
 */
public class Person {

    public static void main(String[] args) {
        Television television = new Television();
        RemoteControl remoteControl = new RemoteControl();

        OnCommand onCommand = new OnCommand(television,"On");
        remoteControl.setCommand(onCommand);
        remoteControl.pressButton();

        OffCommand offCommand = new OffCommand(television,"Off");
        remoteControl.setCommand(offCommand);
        remoteControl.pressButton();

        remoteControl.undo();
        remoteControl.undo();
        remoteControl.redo();
        remoteControl.redo();
        remoteControl.getHistory();
    }

}
