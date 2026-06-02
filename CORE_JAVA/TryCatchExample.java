import java.util.Scanner;

public class TryCatchExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Enter the first integer: ");
            int dividend = sc.nextInt();
            
            System.out.print("Enter the second integer: ");
            int divisor = sc.nextInt();
            
            int result = dividend / divisor;
            System.out.println("Result: " + dividend + " / " + divisor + " = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero. Please enter a non-zero divisor.");
        } finally {
            sc.close();
        }
    }
}
