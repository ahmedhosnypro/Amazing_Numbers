package numbers;

import static numbers.Number.*;
import static numbers.Number.isJumping;

public class Print {
    public static void printInstructions(){
        System.out.print("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be processed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
    }
    public static void printProperties(long input){
        System.out.println("Properties of " + input);
        System.out.println("\t\t" + "even: " + isEven(input));
        System.out.println("\t\t" + " odd: " + isOdd(input));
        System.out.println("\t\t" + "buzz: " + isBuzz(input));
        System.out.println("\t\t" + "duck: " + isDuck(input));
        System.out.println("\t\t" + "Palindromic : " + isPalindromic(input));
        System.out.println("\t\t" + "gapful: " + isGapful(input));
        System.out.println("\t\t" + "spy: " + isSpy(input));
        System.out.println("\t\t" + "square: " + isSquare(input));
        System.out.println("\t\t" + "sunny: " + isSunny(input));
        System.out.println("\t\t" + "jumping: " + isJumping(input));
        System.out.println("\t\t" + "happy: " + isHappy(input));
        System.out.println("\t\t" + "sad: " + isSad(input));
        //System.out.println("\t\t" + ": " + );
    }
    public static void printProperties(long input1, long input2){
        System.out.println();
        for (int i = 0; i < input2; i++){
            System.out.println("\t\t\t" + input1 + " is "
                    + (isBuzz(input1) ? "buzz, " : "")
                    + (isDuck(input1) ? "duck, " : "")
                    + (isEven(input1) ? "even, " : "")
                    + (isOdd(input1) ? "odd, " : "")
                    + (isPalindromic(input1) ? "palindromic, " : "")
                    + (isGapful(input1) ? "gapful, " : "")
                    + (isSpy(input1) ? "spy, " : "")
                    + (isSquare(input1) ? "square, " : "")
                    + (isSunny(input1) ? "sunny, " : "")
                    + (isJumping(input1) ? "jumping, " : "")
                    + (isHappy(input1) ? "happy, " : "")
                    + (isSad(input1) ? "sad, " : "")
            );
            input1++;
        }
    }
    public static void printProperties(long[] longs){
        System.out.println();
        for (int i = 0; i < longs.length; i++){
            System.out.println("\t\t\t" + longs[i] + " is "
                    + (isBuzz(longs[i]) ? "buzz, " : "")
                    + (isDuck(longs[i]) ? "duck, " : "")
                    + (isEven(longs[i]) ? "even, " : "")
                    + (isOdd(longs[i]) ? "odd, " : "")
                    + (isPalindromic(longs[i]) ? "palindromic, " : "")
                    + (isGapful(longs[i]) ? "gapful, " : "")
                    + (isSpy(longs[i]) ? "spy, " : "")
                    + (isSquare(longs[i]) ? "square, " : "")
                    + (isSunny(longs[i]) ? "sunny, " : "")
                    + (isJumping(longs[i]) ? "jumping, " : "")
                    + (isHappy(longs[i]) ? "happy, " : "")
                    + (isSad(longs[i]) ? "sad, " : "")
            );
            longs[i]++;
        }
    }
}
