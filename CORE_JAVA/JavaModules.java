/*
 * Java Modules Example
 * This example demonstrates how to create and use Java modules (Java 9+)
 * 
 * Structure:
 * com.utils/
 *   module-info.java
 *   com/utils/StringUtils.java
 * 
 * com.greetings/
 *   module-info.java
 *   com/greetings/Greetings.java
 * 
 * To compile and run:
 * 1. Compile modules:
 *    javac --module-source-path src -d mods src/com.utils/module-info.java src/com.utils/com/utils/StringUtils.java
 *    javac --module-path mods --module-source-path src -d mods src/com.greetings/module-info.java src/com.greetings/com/greetings/Greetings.java
 * 
 * 2. Run:
 *    java --module-path mods -m com.greetings/com.greetings.Greetings
 */

// This is a demonstration file showing the module structure

// File 1: com.utils/module-info.java
/*
module com.utils {
    exports com.utils;
}
*/

// File 2: com.utils/com/utils/StringUtils.java
/*
package com.utils;

public class StringUtils {
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
    
    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }
}
*/

// File 3: com.greetings/module-info.java
/*
module com.greetings {
    requires com.utils;
}
*/

// File 4: com.greetings/com/greetings/Greetings.java
/*
package com.greetings;

import com.utils.StringUtils;

public class Greetings {
    public static void main(String[] args) {
        String greeting = "Hello, Modular Java!";
        System.out.println("Original: " + greeting);
        System.out.println("Reversed: " + StringUtils.reverse(greeting));
        System.out.println("Uppercase: " + StringUtils.toUpperCase(greeting));
    }
}
*/

public class JavaModules {
    public static void main(String[] args) {
        System.out.println("Java Modules Example (See comments in source code for detailed setup)");
        System.out.println("\nThis demonstrates the module system in Java 9+");
        System.out.println("Module benefits:");
        System.out.println("1. Encapsulation: Control what is exported from a module");
        System.out.println("2. Explicit Dependencies: Declare required modules");
        System.out.println("3. Cleaner Classpath: Organize code into logical units");
        System.out.println("4. Version Control: Manage module versions");
    }
}
