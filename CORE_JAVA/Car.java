public class Car {
    private String make;
    private String model;
    private int year;
    
    // Constructor
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    
    // Method to display car details
    public void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}

class CarObjectCreation {
    public static void main(String[] args) {
        // Create Car objects
        Car car1 = new Car("Toyota", "Camry", 2022);
        Car car2 = new Car("Honda", "Accord", 2023);
        Car car3 = new Car("BMW", "X5", 2021);
        
        // Display details
        car1.displayDetails();
        System.out.println();
        
        car2.displayDetails();
        System.out.println();
        
        car3.displayDetails();
    }
}
