public class MethodOverloading {
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static double add(double a, double b) {
        return a + b;
    }
    
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
    
    public static void main(String[] args) {
        System.out.println("Sum of 10 and 20 (integers): " + add(10, 20));
        
        System.out.println("Sum of 10.5 and 20.3 (doubles): " + add(10.5, 20.3));
        
        System.out.println("Sum of 5, 10, and 15 (three integers): " + add(5, 10, 15));
    }
}
