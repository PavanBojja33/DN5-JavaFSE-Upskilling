import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Record to represent a Person (Java 16+)
record Person(String name, int age) {
}

public class Records {
    public static void main(String[] args) {
        // Create instances of Person record
        Person person1 = new Person("Alice", 25);
        Person person2 = new Person("Bob", 17);
        Person person3 = new Person("Charlie", 30);
        Person person4 = new Person("Diana", 16);
        Person person5 = new Person("Eve", 22);
        
        // Create a list of persons
        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        
        System.out.println("All People:");
        people.forEach(System.out::println);
        
        // Filter persons with age >= 18 using Streams
        List<Person> adults = people.stream()
                                    .filter(p -> p.age() >= 18)
                                    .collect(Collectors.toList());
        
        System.out.println("\nPeople aged 18 and above:");
        adults.forEach(System.out::println);
    }
}
