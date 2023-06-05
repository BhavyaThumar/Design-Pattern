//Diff between Decorator and Composite 
// Use to extend Existing class with new functionalty  without inheritence

// Component interface
interface Car {
    public String getDescription();

    public double getCost();
}

// Concrete component
class BasicCar implements Car {

    public String getDescription() {
        return "Basic car";
    }

    public double getCost() {
        return 10000;
    }
}

// Decorator class
abstract class CarDecorator implements Car {
    public Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    public String getDescription() {
        return car.getDescription();
    }

    public double getCost() {
        return car.getCost();
    }
}

// Concrete decorator class
class SportsPackage extends CarDecorator {
    public SportsPackage(Car car) {
        super(car);
    }

    public String getDescription() {
        return car.getDescription() + ", sports package";
    }

    public double getCost() {
        return car.getCost() + 5000;
    }
}

// Concrete decorator class
class LuxuryPackage extends CarDecorator {
    public LuxuryPackage(Car car) {
        super(car);
    }

    public String getDescription() {
        return car.getDescription() + ", luxury package";
    }

    public double getCost() {
        return car.getCost() + 10000;
    }
}

// Client code
public class Decorator1 {
    public static void main(String[] args) {
        Car car = new BasicCar();
        car = new SportsPackage(car);
        car = new LuxuryPackage(car);
        System.out.println("Description: " + car.getDescription());
        System.out.println("Cost: " + car.getCost());
    }
}
