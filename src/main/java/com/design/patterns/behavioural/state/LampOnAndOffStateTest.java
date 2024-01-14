package com.design.patterns.behavioural.state;

/**
 * The State pattern is a design pattern that allows an object to change
 * its behavior based on its internal state. It is useful when you have
 * an object that can be in different states, and you want to perform
 * different actions depending on the current state.
 *
 * For example, imagine you have a lamp object that can be on or off.
 * When the lamp is on, you want to perform certain actions like emitting
 * light, but when it is off, you want to perform other actions like turning
 * off the light.
 *
 * With the State pattern, you can create a State interface or abstract class
 * that defines the methods that the lamp object can use to perform its actions.
 * You can then create two concrete state classes: OnState and OffState. Each
 * state class provides its own implementation of the methods defined in the State
 * interface, based on the behavior associated with that state.
 *
 * When the lamp object changes its state, it changes its behavior by delegating
 * requests to the appropriate concrete state object. This allows the lamp object
 * to change its behavior without changing its class, and also allows the concrete
 * state objects to be easily swapped in and out, making the code more modular and
 * easier to maintain.
 */

/**
 * Adding a new state does not necessarily violate SOLID principles. In fact, the
 * State pattern is designed to be extensible, making it easy to add new states without
 * modifying the existing code.
 *
 * To add a new state, you would simply create a new class that implements the LampState
 * interface, and provide your own implementation of the switchOn() and switchOff() methods
 * based on the behavior associated with that state.
 *
 * Once you have created the new state class, you would update the Lamp class to include
 * the new state in its setState() method, allowing the lamp to transition to the
 * new state as needed.
 *
 * By doing this, you are adhering to the Open-Closed Principle, which states that classes
 * should be open for extension but closed for modification. The State pattern allows you
 * to add new states without modifying the existing code, making it a good example of this
 * principle.
 */

// State interface
interface LampState{
    void switchOn();
    void switchOff();
}

class OnState implements LampState {

    @Override
    public void switchOn() {
        System.out.println("Already Lamp on...");
    }

    @Override
    public void switchOff() {
        System.out.println("Lamp off...");
    }
}

class OffState implements LampState {

    @Override
    public void switchOn() {
        System.out.println("Lamp on..");
    }

    @Override
    public void switchOff() {
        System.out.println("Already lamp off...");
    }
}

// Context class
class Lamp {
    LampState currentState;

    public Lamp(){
        currentState = new OffState();
    }

    public void setState(LampState state) {
        currentState = state;
    }

    public void switchOff() {
        currentState.switchOff();
        setState(new OffState());
    }

    public void switchOn() {
        currentState.switchOn();
        setState(new OnState());
    }
}

public class LampOnAndOffStateTest {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        lamp.switchOn();
        lamp.switchOff();
        lamp.switchOff();
    }
}
