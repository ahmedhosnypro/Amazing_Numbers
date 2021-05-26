package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a natural number:");
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        if (userInput > 0){
            printProperties(userInput);
        }
        else {
            System.out.println("This number is not natural!");
        }
    }

    static void printProperties (int userInput){
        System.out.println("Properties of " + userInput);
        System.out.println("\t\t" + "even: " + isEven(userInput));
        System.out.println("\t\t" + " odd: " + isOdd(userInput));
        System.out.println("\t\t" + "buzz: " + isBuzz(userInput));
        System.out.println("\t\t" + "duck: " + isDuck(userInput));
        //System.out.println("\t\t" + ": " + );
    }
    static boolean isEven (int userInput){
        return userInput % 2 == 0;
    }
    static boolean isOdd (int userInput){
        return userInput % 2 != 0;
    }
    static boolean isBuzz (int userInput) {
        if (userInput > 10) {
            int lastDigit = userInput % 10;
                return userInput % 7 == 0 || lastDigit == 7;
        }
        else return userInput == 7;
    }
    static boolean isDuck(int userInput){
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
}
