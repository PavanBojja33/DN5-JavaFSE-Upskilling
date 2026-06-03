import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> students = new HashMap<>();
        
        System.out.println("=== Student ID to Name Mapping ===\n");
        
        // Add entries
        System.out.println("Add student entries (type 'done' to finish):");
        while (true) {
            System.out.print("Enter student ID (or 'done' to exit): ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            
            try {
                int id = Integer.parseInt(input);
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                students.put(id, name);
                System.out.println("Added successfully.\n");
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID. Please enter a number.\n");
            }
        }
        
        // Retrieve and display
        System.out.println("\n=== Retrieve Student Information ===");
        System.out.print("Enter student ID to retrieve: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            if (students.containsKey(id)) {
                System.out.println("Student Name: " + students.get(id));
            } else {
                System.out.println("Student with ID " + id + " not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
        }
        
        // Display all
        System.out.println("\nAll Students:");
        for (Integer id : students.keySet()) {
            System.out.println("ID: " + id + " | Name: " + students.get(id));
        }
        
        scanner.close();
    }
}
