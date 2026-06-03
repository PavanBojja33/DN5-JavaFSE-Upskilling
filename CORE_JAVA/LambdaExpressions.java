import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpressions {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Cherry");
        fruits.add("Date");
        fruits.add("Elderberry");
        
        System.out.println("Original List:");
        fruits.forEach(fruit -> System.out.println(fruit));
        
        // Sort using lambda expression
        Collections.sort(fruits, (s1, s2) -> s1.compareTo(s2));
        
        System.out.println("\nSorted List (Ascending):");
        fruits.forEach(fruit -> System.out.println(fruit));
        
        // Sort in descending order
        Collections.sort(fruits, (s1, s2) -> s2.compareTo(s1));
        
        System.out.println("\nSorted List (Descending):");
        fruits.forEach(fruit -> System.out.println(fruit));
    }
}
