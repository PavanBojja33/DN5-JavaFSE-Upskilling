import java.util.Scanner;

public class ArraySumAndAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        
        double[] array = new double[n];
        
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = sc.nextDouble();
        }
        
        double sum = 0;
        for (double element : array) {
            sum += element;
        }
        
        double average = sum / n;
        
        System.out.println("\nResults:");
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        
    }
}
