

/**
 * Decorator is a structural design pattern that lets you attach new behaviors to objects 
 * by placing these objects inside special wrapper objects that contain the behaviors. 
 * 
 * Use the Decorator pattern when you need to be able to assign extra behaviors to objects
 *  at runtime without breaking the code that uses these objects.
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        Vehicle basicCar = new BasicCar();
        System.out.println("Cost of basic car: " + basicCar.cost());

        // Apply discount using the decorator
        Vehicle discountedCar = new TenPercentDiscount(basicCar);
        System.out.println("Cost of discounted car: " + discountedCar.cost());
 
    }
}

// Component interface representing a Vehicle
interface Vehicle {
    double cost();
}

// Concrete Component representing a specific type of vehicle
class BasicCar implements Vehicle {
    @Override
    public double cost() {
        return 100; // Some base cost for a basic car
    }
}

// Decorator abstract class
abstract class DiscountDecorator implements Vehicle {
    private final Vehicle decoratedVehicle;

    public DiscountDecorator(Vehicle decoratedVehicle) {
        this.decoratedVehicle = decoratedVehicle;
    }

    @Override
    public double cost() {
        return decoratedVehicle.cost();
    }
}

// Concrete Decorator adding a discount to the cost
class TenPercentDiscount extends DiscountDecorator {
    public TenPercentDiscount(Vehicle decoratedVehicle) {
        super(decoratedVehicle);
    }

    @Override
    public double cost() {
        double originalCost = super.cost();
        double discountedCost = originalCost * 0.9; // 10% discount
        return discountedCost;
    }
}