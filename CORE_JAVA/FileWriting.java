import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Enter a string to write to file: ");
            String input = sc.nextLine();
            
            FileWriter fileWriter = new FileWriter("output.txt");
            fileWriter.write(input);
            fileWriter.close();
            
            System.out.println("Data has been written to output.txt successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
