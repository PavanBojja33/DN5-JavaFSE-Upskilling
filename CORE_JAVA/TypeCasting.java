import java.util.Scanner;

public class TypeCasting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double value = 9.78;
        int intValue = (int) value;
        System.out.println(intValue);
        int number = 5;
        double doubleValue = (double) number;
        System.out.println(doubleValue);
        sc.close();
    }
}
