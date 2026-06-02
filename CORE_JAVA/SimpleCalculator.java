import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        
        System.out.println("\nChoose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.print("Enter your choice : ");
        
        int choice = sc.nextInt();
        int result = 0;
        
        switch(choice) {
            case 1:
                result = num1 + num2;
                System.out.println("\nResult: " + num1 + " + " + num2 + " = " + result);
                break;
            case 2:
                result = num1 - num2;
                System.out.println("\nResult: " + num1 + " - " + num2 + " = " + result);
                break;
            case 3:
                result = num1 * num2;
                System.out.println("\nResult: " + num1 + " * " + num2 + " = " + result);
                break;
            case 4:
                if (num2 == 0) {
                    System.out.println("\nError: Cannot divide by zero!");
                } else {
                    result = num1 / num2;
                    System.out.println("\nResult: " + num1 + " / " + num2 + " = " + result);
                }
                break;
            default:
                System.out.println("\nInvalid choice! Please enter 1, 2, 3, or 4.");
        }
    }
}
