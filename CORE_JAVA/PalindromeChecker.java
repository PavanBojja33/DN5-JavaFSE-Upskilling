import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        int i=0,j=input.length();
        boolean res=true;
        while(i<=j){
            if(input.charAt(i) != input.charAt(j)){
                res=false;
                break;
            }
        }
        
        if (res) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
        
    }
}
