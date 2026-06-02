public class OperatorPrecedence {
    public static void main(String[] args) {
        int result1 = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + result1 + " because multiplication before addition");
        int result2 = (10 + 5) * 2;
        System.out.println("(10 + 5) * 2 = " + result2 + " because parentheses first then multiplication");
        int result3 = 20 / 5 + 3;
        System.out.println("20 / 5 + 3 = " + result3 + " because division before addition");
        int result4 = 20 / (5 + 3);
        System.out.println("20 / (5 + 3) = " + result4 + " because parentheses first then division");
        int result5 = 5 + 4 - 3 * 2;
        System.out.println("5 + 4 - 3 * 2 = " + result5 + " because multiplication before addition and subtraction");
    }
}
