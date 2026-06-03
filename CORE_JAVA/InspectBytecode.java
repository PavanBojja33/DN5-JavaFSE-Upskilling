/*
 * Using javap to Inspect Bytecode
 * 
 * javap is a tool that displays information about class files.
 * 
 * Steps to use:
 * 1. Create a Java class (this file)
 * 2. Compile it: javac InspectBytecode.java
 * 3. Run javap:
 *    - javap InspectBytecode (shows class structure)
 *    - javap -c InspectBytecode (shows bytecode)
 *    - javap -v InspectBytecode (shows detailed output)
 *    - javap -private InspectBytecode (shows private members)
 */

public class InspectBytecode {
    private int x;
    private String name;
    
    public InspectBytecode(int x, String name) {
        this.x = x;
        this.name = name;
    }
    
    public void add(int value) {
        x += value;
    }
    
    public int getX() {
        return x;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void display() {
        System.out.println("X: " + x + ", Name: " + name);
    }
    
    public static void main(String[] args) {
        InspectBytecode obj = new InspectBytecode(10, "Test");
        obj.display();
        obj.add(5);
        obj.display();
    }
}

/*
 * Example javap output:
 * 
 * javap InspectBytecode
 * Compiled from "InspectBytecode.java"
 * public class InspectBytecode {
 *   private int x;
 *   private java.lang.String name;
 *   public InspectBytecode(int, java.lang.String);
 *   public void add(int);
 *   public int getX();
 *   public java.lang.String getName();
 *   public void setName(java.lang.String);
 *   public void display();
 *   public static void main(java.lang.String[]);
 * }
 * 
 * The bytecode inspection helps understand:
 * - Class structure and hierarchy
 * - Method signatures
 * - Field types and access modifiers
 * - Internal JVM operations and stack manipulation
 */
