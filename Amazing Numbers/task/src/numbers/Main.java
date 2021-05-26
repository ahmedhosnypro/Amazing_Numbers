package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        write your code here
        System.out.println("Enter a natural number:");
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        checkForNatural (userInput);
        //check for buzz
//        int lastDigit = userInput % 10;
//        int remainingNumber = (userInput- lastDigit) / 10;
//        int result_of_subtraction = remainingNumber - lastDigit;
//        if (result_of_subtraction % 7 == 0){
//
//        }
    }

    static void checkForNatural (int userInput) {
        if (userInput > 0) {
            if (userInput % 2 == 0) {
                System.out.println("This number is Even.");
            } else {
                System.out.println("This number is Odd.");
            }
            chekForBuzz (userInput);
        } else {
            System.out.println("This number is not natural!");
        }
    }

    static void chekForBuzz (int userInput) {
        boolean isDivisible = false;
        boolean isEnd7 = false;
        if (userInput > 10) {
            int lastDigit = userInput % 10;
            if (lastDigit == 7) {
                isEnd7 = true;
            }
            if (userInput % 7 == 0) {
                isDivisible = true;
            }
        } else {
            if (userInput == 7) {
                isEnd7 = true;
                isDivisible = true;
            }
        }

        if (isDivisible || isEnd7) {
            System.out.println("It is a Buzz number.");
        } else {
            System.out.println("It is not a Buzz number.");
        }
        System.out.println("Explanation:");
        if (isDivisible && isEnd7) {
            System.out.println(userInput + " is divisible by 7 and it ends with 7.");
        } else if (isDivisible) {
            System.out.println(userInput + " is divisible by 7.");
        } else if (isEnd7) {
            System.out.println(userInput + " is ends with 7.");
        } else {
            System.out.println(userInput + " is neither divisible by 7 nor it ends with 7.");
        }
    }
}
