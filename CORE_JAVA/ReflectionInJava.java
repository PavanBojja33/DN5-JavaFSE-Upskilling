import java.lang.reflect.*;

public class ReflectionInJava {
    private String name;
    private int age;
    
    public ReflectionInJava(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public static void main(String[] args) {
        try {
            // Load the class using reflection
            Class<?> clazz = Class.forName("ReflectionInJava");
            System.out.println("Class loaded: " + clazz.getName());
            
            // Get all declared methods
            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("\nDeclared Methods:");
            for (Method method : methods) {
                System.out.println("Method: " + method.getName());
                Parameter[] parameters = method.getParameters();
                System.out.print("  Parameters: ");
                for (Parameter param : parameters) {
                    System.out.print(param.getType().getSimpleName() + " " + param.getName() + ", ");
                }
                System.out.println();
            }
            
            // Get all declared fields
            Field[] fields = clazz.getDeclaredFields();
            System.out.println("\nDeclared Fields:");
            for (Field field : fields) {
                System.out.println("Field: " + field.getName() + " (" + field.getType().getSimpleName() + ")");
            }
            
            // Create an instance using reflection
            Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
            Object instance = constructor.newInstance("John", 30);
            System.out.println("\nInstance created via reflection.");
            
            // Invoke a method using reflection
            Method displayMethod = clazz.getMethod("displayInfo");
            System.out.println("Calling displayInfo() method:");
            displayMethod.invoke(instance);
            
            // Invoke a getter method
            Method getNameMethod = clazz.getMethod("getName");
            Object result = getNameMethod.invoke(instance);
            System.out.println("Result of getName(): " + result);
            
            // Invoke setter method
            Method setNameMethod = clazz.getMethod("setName", String.class);
            setNameMethod.invoke(instance, "Jane");
            System.out.println("Name changed to 'Jane' via reflection.");
            
            // Call displayInfo again
            displayMethod.invoke(instance);
            
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Reflection error: " + e.getMessage());
        }
    }
}
