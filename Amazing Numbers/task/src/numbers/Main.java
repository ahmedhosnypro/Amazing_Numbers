package numbers;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        printInstructions();
        runProgram();
    }
    static void printInstructions(){
        System.out.print("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameters show how many consecutive numbers are to be processed;\n" +
                "- two natural numbers and a property to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
    }

    static void runProgram(){
        while (true) {
            //getting input
            String[] input = Scanner();
            if (!chooseRequest(input, input.length)){
                break;
            }
        }
    }
    static String[] Scanner() {
        System.out.println("\nEnter a request: ");
        String stringInputArray = scanner.nextLine();
        return stringInputArray.split(" ");
    }

    static boolean chooseRequest(String[] stringInputArray, int stringInputArrayLength){
        boolean isContinue = true;
        long[] longInputArray = new long[stringInputArray.length];
        if (stringInputArrayLength < 3) {
            for (int i = 0; i < stringInputArrayLength; i++) {
                try {
                    longInputArray[i] = Long.parseLong(stringInputArray[i]);
                }
                catch (NumberFormatException e){
                    if (i == 0){
                        System.out.println("The first parameter should be a natural number or zero.");
                    }
                    if (i == 1){
                        System.out.println("The second parameter should be a natural number.");
                        return isContinue;
                    }
                }
            }
        }
        else if (stringInputArrayLength == 3){
            for (int i = 0; i < stringInputArrayLength - 1; i++) {
                try {
                    longInputArray[i] = Long.parseLong(stringInputArray[i]);
                }
                catch (NumberFormatException e){
                    if (i == 0){
                        System.out.println("The first parameter should be a natural number or zero.");
                    }
                    if (i == 1){
                        System.out.println("The second parameter should be a natural number.");
                        return isContinue;
                    }
                }

            }
        }

        switch (stringInputArrayLength){
            case 1:
                isContinue = processRequest(longInputArray[0]);
                break;
            case 2:
                processRequest(longInputArray[0], longInputArray[1]);
                break;
            case 3:
                processRequest(longInputArray[0], longInputArray[1], stringInputArray[stringInputArrayLength - 1]);
                break;
            default:
                printInstructions();
                break;
        }
        return isContinue;
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
    static void processRequest(long input1, long input2){
        //boolean isContinue = true;

        if (input1 > 0 && input2 > 0) {
            printProperties(input1, input2);
        }
        else if (input2 < 0 || input2 == 0){
            System.out.println("The second parameter should be a natural number.");
        }

        //return isContinue;
    }
    static void processRequest(long input1, long input2, String filter){
        if (input1 > 0 && input2 > 0) {
            long[] longs = filter(input1, input2, filter);
            if (longs.length > 0){
                printProperties(longs);
            }
        }
        else if (input2 < 0 || input2 == 0){
            System.out.println("\nThe second parameter should be a natural number.");
        }
    }


    static long[] filter(long input1, long input2, String filter){
        long[] longs = new  long[(int) input2];
        filter = filter.toLowerCase();
        String s = "";
        int i = 0;
        while (i < input2){
            Number number = new Number(input1);
            switch (filter) {
                case "even":
                    if (number.isEven()) {
                        longs[i] = number.value;
                        i++;
                    }
                    break;
                case "odd":
                    if (number.isOdd()) {
                        longs[i] = number.value;
                        i++;
                    }
                    break;
                case "buzz":
                    if (number.isBuzz()) {
                        longs[i] = number.value;
                        i++;
                    }
                    break;
                case "duck":
                    if (number.isDuck()) {
                        longs[i] = number.value;
                        i++;
                    }
                    break;
                case "palindromic":
                    if (number.isPalindromic()) {
                        longs[i] = number.value;
                        i++;
                    }
                    break;
                case "gapful":
                    if (number.isGapful()) {
                        longs[i] = number.value;
                        i++;
                    }
                    break;
                case "spy":
                    if (number.isSpy()) {
                        longs[i] = number.value;
                        i++;
                    }
                    break;
                default:
                    System.out.println("The property [" + filter.toUpperCase() + "] is wrong Available properties: " +
                            "[BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD]");
                    longs = new long[0];
                    i =(int) input2;
                    break;
            }
            input1++;
        }
        return longs;
    }

    static void printProperties(long input){
        Number number = new Number(input);
        System.out.println("Properties of " + input);
        System.out.println("\t\t" + "even: " + number.isEven());
        System.out.println("\t\t" + " odd: " + number.isOdd());
        System.out.println("\t\t" + "buzz: " + number.isBuzz());
        System.out.println("\t\t" + "duck: " + number.isDuck());
        System.out.println("\t\t" + "Palindromic : " + number.isPalindromic());
        System.out.println("\t\t" + "gapful: " + number.isGapful());
        System.out.println("\t\t" + "spy: " + number.isSpy());
        //System.out.println("\t\t" + ": " + );
    }
    static void printProperties(long input1, long input2){
        System.out.println();
        for (int i = 0; i < input2; i++){
            Number number = new Number(input1);
            System.out.println("\t\t\t" + input1 + " is "
                            + (number.isBuzz() ? "buzz, " : "")
                            + (number.isDuck() ? "duck, " : "")
                            + (number.isEven() ? "even, " : "")
                            + (number.isOdd() ? "odd, " : "")
                            + (number.isPalindromic() ? "palindromic, " : "")
                            + (number.isGapful() ? "gapful, " : "")
                            + (number.isSpy() ? "spy, " : "")
                    );
            input1++;
        }
    }
    static void printProperties(long[] longs){
        System.out.println();
        for (int i = 0; i < longs.length; i++){
            Number number = new Number(longs[i]);
            System.out.println("\t\t\t" + longs[i] + " is "
                    + (number.isBuzz() ? "buzz, " : "")
                    + (number.isDuck() ? "duck, " : "")
                    + (number.isEven() ? "even, " : "")
                    + (number.isOdd() ? "odd, " : "")
                    + (number.isPalindromic() ? "palindromic, " : "")
                    + (number.isGapful() ? "gapful, " : "")
                    + (number.isSpy() ? "spy, " : "")
            );
            longs[i]++;
        }
    }
}
