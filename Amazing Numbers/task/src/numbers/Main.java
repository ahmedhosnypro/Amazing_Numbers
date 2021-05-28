package numbers;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;
import static numbers.Request.*;
import static numbers.Print.printInstructions;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        printInstructions();
        runProgram();
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
        System.out.print("\nEnter a request: ");
        String stringInputArray = scanner.nextLine();
        return stringInputArray.split(" ");
    }
}
