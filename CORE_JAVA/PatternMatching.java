public class PatternMatching {
    // Method that uses pattern matching with switch
    public static void checkType(Object obj) {
        String result = switch (obj) {
            case Integer i -> "Integer: " + i;
            case String s -> "String: " + s;
            case Double d -> "Double: " + d;
            case Boolean b -> "Boolean: " + b;
            case null -> "Null value";
            default -> "Unknown type: " + obj.getClass().getSimpleName();
        };
        System.out.println(result);
    }
    
    public static void main(String[] args) {
        System.out.println("Pattern Matching with Switch (Java 21):\n");
        
        checkType(42);
        checkType("Hello, World!");
        checkType(3.14);
        checkType(true);
        checkType(null);
        checkType(new Object());
    }
}
