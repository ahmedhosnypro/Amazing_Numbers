package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter 0 to exit.");
        while (true){
            System.out.println("Enter a request:");
            long userInput = scanner.nextLong();
            if (userInput > 0){
                printProperties(userInput);
            }
            else if (userInput == 0){
                System.out.println("Goodbye!");
                break;
            }
            else {
                System.out.println("The first parameter should be a natural number or zero.");
            }
        }
    }

    static void printProperties (long userInput){
        System.out.println("Properties of " + userInput);
        System.out.println("\t\t" + "even: " + isEven(userInput));
        System.out.println("\t\t" + " odd: " + isOdd(userInput));
        System.out.println("\t\t" + "buzz: " + isBuzz(userInput));
        System.out.println("\t\t" + "duck: " + isDuck(userInput));
        System.out.println("\t\t" + "Palindromic : " + isPalindromic(userInput));
        //System.out.println("\t\t" + ": " + );
    }
    static boolean isEven (long userInput){
        return userInput % 2 == 0;
    }
    static boolean isOdd (long userInput){
        return userInput % 2 != 0;
    }
    static boolean isBuzz (long userInput) {
        if (userInput > 10) {
            long lastDigit = userInput % 10;
                return userInput % 7 == 0 || lastDigit == 7;
        }
        else return userInput == 7;
    }
    static boolean isDuck(long userInput){
        String toString = String.valueOf(userInput);
        boolean isDuck = false;
        for (int i = 1; i < toString.length(); i++){
            char ch = toString.charAt(i);
            if (ch == '0'){
                isDuck = true;
                break;
            }
        }
        return isDuck;
    }
    static boolean isPalindromic (long userInput){
        String toString = String.valueOf(userInput);
        StringBuilder sb2 = new StringBuilder(String.valueOf(userInput)).reverse();
        String reversedString  = sb2.toString();
        return toString.equals(reversedString);
    }
}
