package numbers;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!");
        printInstructions();
        runProgram();
    }
    static void printInstructions(){
        System.out.print("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameters show how many consecutive numbers are to be processed;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n" +
                "\n");
    }

    static void runProgram(){
        while (true) {
            //getting input
            long[] longInputArray = Scanner();

            //one number input
            if (longInputArray.length == 1) {
                if (!processRequest(longInputArray[0]))
                    break;
            }
            else if (longInputArray.length > 1){
                if (!processRequest(longInputArray[0], longInputArray[1]))
                    break;
            }
            else {
                printInstructions();
            }
        }
    }
    static long[] Scanner() {
        System.out.println("\"Enter a request: > ");
        String stringInput = scanner.nextLine();
        String[] stringInputArray = stringInput.split(" ");
        long[] longInputArray = new long[stringInputArray.length];
        for (int i = 0; i < longInputArray.length; i++){
            longInputArray[i] = Long.parseLong(stringInputArray[i]);
        }
        return longInputArray;
    }

    static boolean processRequest(long input){
        boolean isContinue = true;
        if (input > 0) {
            printProperties(input);
        } else if (input == 0) {
            System.out.println("Goodbye!");
            isContinue = false;
        } else {
            System.out.println("The first parameter should be a natural number or zero.");
        }
        return isContinue;
    }
    static boolean processRequest(long input1, long input2){
        boolean isContinue = true;

        if (input1 > 0 && input2 > 0) {
            printProperties(input1, input2);
        }

        //first parameter
//        else if (input1 == 0) {
//            System.out.println("Goodbye!");
//            isContinue = false;
//        }
//        else if (input1 < 0){
//            System.out.println("The first parameter should be a natural number or zero.");
//        }

        //second parameter
//        else if (input2 == 0){
//            processRequest(input1);
//        }
        else if (input2 < 0 || input2 == 0){
            System.out.println("The second parameter should be a natural number.");
        }

        return isContinue;
    }

    static void printProperties(long input){
        System.out.println("Properties of " + input);
        System.out.println("\t\t" + "even: " + isEven(input));
        System.out.println("\t\t" + " odd: " + isOdd(input));
        System.out.println("\t\t" + "buzz: " + isBuzz(input));
        System.out.println("\t\t" + "duck: " + isDuck(input));
        System.out.println("\t\t" + "Palindromic : " + isPalindromic(input));
        System.out.println("\t\t" + "gapful: " + isGapful(input));
        //System.out.println("\t\t" + ": " + );
    }
    static void printProperties(long input1, long input2){
        System.out.println();
        for (int i = 0; i < input2; i++){
            System.out.println("\t\t\t" + input1 + " is "
                            + (isBuzz(input1) ? "buzz, " : "")
                            + (isDuck(input1) ? "duck, " : "")
                            + (isEven(input1) ? "even, " : "")
                            + (isOdd(input1) ? "odd, " : "")
                            + (isPalindromic(input1) ? "palindromic" : "")
                            + (isGapful(input1) ? "gapful, " : "")
                    );
            input1++;
        }
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
    static boolean isGapful(long input){
        String s = String.valueOf(input);
        boolean isGapful = false;
        if (s.length() >= 3){
            char fstDigit = s.charAt(0);
            char lstDigit = s.charAt(s.length() - 1);
            String concatenated = fstDigit + "" + lstDigit;
            long concatNumber = Long.parseLong(concatenated);
            if (input % concatNumber == 0)
                isGapful = true;
        }
        return isGapful;
    }
}
