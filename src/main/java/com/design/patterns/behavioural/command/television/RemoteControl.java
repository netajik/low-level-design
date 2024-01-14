package com.design.patterns.behavioural.command.television;

import java.util.Stack;

/**
 * Invoker/producer
 */
class RemoteControl {

    private  Command command;

    private final Stack<Command> undostack = new Stack<>();
    private final Stack<Command> redostack = new Stack<>();
    private final Stack<Command> historyStack = new Stack<>();

    public void pressButton() {
        command.execute();
        undostack.push(command);
        historyStack.push(command);
    }

    public void undo() {
        if(!undostack.isEmpty()){
            System.out.println("undo: "+undostack.peek().getName());
            historyStack.push(undostack.peek());
            redostack.push(undostack.pop());
        }
    }

    public void redo() {
        if(!redostack.isEmpty()){
            System.out.println("redo: "+redostack.peek().getName());
            historyStack.push(redostack.peek());
            undostack.push(redostack.pop());
        }
    }

    public void getHistory(){
        System.out.print("History: ");
        while(!historyStack.isEmpty()){
            System.out.print(this.historyStack.pop().getName()+" ");
        }
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

}
