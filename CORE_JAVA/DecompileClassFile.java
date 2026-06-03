/*
 * Decompile a Class File
 * 
 * Java bytecode (.class files) can be decompiled back to source code.
 * 
 * Popular decompilers:
 * 1. CFR - Modern decompiler (handles Java 8+ features)
 *    Download: https://www.benf.org/other/cfr/
 *    Usage: java -jar cfr.jar ClassName.class
 * 
 * 2. JD-GUI - GUI-based decompiler
 *    Download: http://jd.benf.org/
 * 
 * 3. Procyon - Decompiler with modern language features support
 *    Download: https://github.com/mstrobel/procyon
 * 
 * Steps:
 * 1. Compile this file: javac DecompileClassFile.java
 * 2. Use a decompiler tool:
 *    For CFR: java -jar cfr.jar DecompileClassFile.class
 * 
 * Why decompile?
 * - Recover lost source code
 * - Analyze third-party libraries
 * - Security analysis
 * - Reverse engineering (when legally permitted)
 */

public class DecompileClassFile {
    private String message;
    private int counter;
    
    public DecompileClassFile(String message) {
        this.message = message;
        this.counter = 0;
    }
    
    public void increment() {
        counter++;
    }
    
    public void printMessage() {
        System.out.println("Message: " + message + ", Counter: " + counter);
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public int getCounter() {
        return counter;
    }
    
    public static void main(String[] args) {
        DecompileClassFile obj = new DecompileClassFile("Hello, Decompilation!");
        for (int i = 0; i < 3; i++) {
            obj.printMessage();
            obj.increment();
        }
    }
}

/*
 * Decompiled bytecode is similar to original source,
 * allowing analysis of compiled Java classes.
 * 
 * Note: Always respect copyright and licensing when decompiling code.
 */
