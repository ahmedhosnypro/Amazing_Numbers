package numbers;

import java.util.Locale;

import static numbers.Number.*;

public class Request {
    static void printInstructions(){
        System.out.print("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameters show how many consecutive numbers are to be processed;\n" +
                "- two natural numbers and two properties to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n");
    }
    static boolean chooseRequest(String[] stringInputArray, int stringInputArrayLength){
        boolean isContinue = true;
        long longNum = 0;
        long[] longInputArray = new long[2];
        if (stringInputArrayLength < 2) {
            try {
                longNum = Long.parseLong(stringInputArray[0]);
            } catch (NumberFormatException e) {
                System.out.println("The first parameter should be a natural number or zero.");
                return isContinue;
            }
        }
        else {
            for (int i = 0; i < 2; i++) {
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
                isContinue = processRequest(longNum);
                break;
            case 2:
                isContinue = processRequest(longInputArray[0], longInputArray[1]);
                break;
            case 3:
                isContinue = processRequest(longInputArray[0], longInputArray[1], stringInputArray[2]);
                break;
            case 4:
                isContinue = processRequest(longInputArray[0], longInputArray[1], stringInputArray[2], stringInputArray[3]);
                break;
            default:
                printInstructions();
                break;
        }
        return isContinue;
    }
    static boolean checkProperty (String filter1){
        filter1 = filter1.toLowerCase();
        boolean isProperty = false;
        if (filter1.equals("even") || filter1.equals("odd") || filter1.equals("buzz") || filter1.equals("duck") ||
                filter1.equals("palindromic") || filter1.equals("gapful") || filter1.equals("spy") || filter1.equals("sunny") ||
                filter1.equals("square")){
            isProperty = true;
        }
        return isProperty;
    }
    static boolean checkProperty (String filter1, String filter2){
        filter1 = filter1.toLowerCase();
        filter2 = filter2.toLowerCase();
        boolean isNotMutuallyExclusive = true;
        if ((filter1.equals("even") && filter2.equals("odd")) || (filter1.equals("odd") && filter2.equals("even")) || (filter1.equals("duck") && filter2.equals("spy")) ||
                (filter1.equals("spy") && filter2.equals("duck")) || (filter1.equals("sunny") && filter2.equals("square")) ||
                (filter1.equals("square") && filter2.equals("sunny"))){
            isNotMutuallyExclusive = false;
        }
        return isNotMutuallyExclusive;
    }
    static String checkRequest(long input){
        String  check = "";
        if (input > 0) {
            check = "available";
        } else if (input == 0){
            check = "exit";
        }
        else {
            check = "notAvailable";
        }
        return check;
    }
    static String checkRequest(long input1, long input2){
        String  check = "";
        if (input1 > 0 && input2 > 0) {
            check = "available";
        }
        else if (input1 < 0){
            check = "negativeInput1";
        }
        else if (input1 == 0){
            check = "exit";
        }
        else if (input2 < 0 || input2 == 0){
            check = "wrongInput2";
        }
        return check;
    }
    static String checkRequest(long input1, long input2, String filter){
        String  check = "";
        if (checkProperty(filter)){
            check = checkRequest(input1, input2);
        }
        else {
            check = "wrongProperty1";
        }
        return check;
    }
    static String checkRequest(long input1, long input2, String filter1, String filter2){
        String  check = "";
        if (checkProperty(filter1) && checkProperty(filter2) && checkProperty(filter1, filter2)){
            check = checkRequest(input1, input2);
        }
        else if (!checkProperty(filter1, filter2)){
            check = "mutuallyExclusiveProperties";
        }
        else if (!checkProperty(filter1) && !checkProperty(filter2)){
            check = "wrongProperties";
        }
        else if (!checkProperty(filter1)){
            check = "wrongProperty1";
        }
        else if (!checkProperty(filter2)){
            check = "wrongProperty2";
        }
        return check;
    }

    static boolean processRequest(long input){
        boolean isContinue = true;
        switch (checkRequest(input)){
            case "available":
                printProperties(input);
                break;
            case "notAvailable":
                System.out.println("\nThe first parameter should be a natural number or zero.\n");
                break;
            case "exit":
                System.out.println("\nGoodbye!");
                isContinue = false;
                break;
            default:
                break;
        }
        return isContinue;
    }
    static boolean processRequest(long input1, long input2){
        boolean isContinue = true;

        switch (checkRequest(input1, input2)) {
            case "available":
                printProperties(input1, input2);
                break;
            case "negativeInput1":
                System.out.println("\nThe first parameter should be a natural number or zero.\n");
            case "wrongInput2":
                System.out.println("\nThe second parameter should be a natural number.\n");
                break;
            case "exit":
                System.out.println("\nGoodbye!");
                isContinue = false;
                break;
            default:
                break;
        }

        return isContinue;
    }
    static boolean processRequest(long input1, long input2, String filter){
        boolean isContinue = true;
        switch (checkRequest(input1, input2, filter)){
            case "available":
                int i = 0;
                int cnt = 0;
                long[] longs = new long[(int) input2];
                while (i < input2){
                    if (filter(input1, filter)){
                        longs[i] = input1;
                        i++;
                        cnt++;
                    }
                    input1++;
                }
                if (cnt > 0){
                    printProperties(longs);
                }
                break;
            case "negativeInput1":
                System.out.println("\nThe first parameter should be a natural number or zero.\n");
                break;
            case "wrongInput2":
                System.out.println("\nThe second parameter should be a natural number.\n");
                break;
            case "wrongProperty1":
                System.out.println("\nThe property [" + filter + "] is wrong.\n" +
                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]\n");
                break;
            case "exit":
                System.out.println("\nGoodbye!");
                isContinue = false;
                break;
            default:
                break;
        }
        return isContinue;
    }
    static boolean processRequest(long input1, long input2, String filter1, String filter2){
        boolean isContinue = true;
        switch (checkRequest(input1, input2, filter1, filter2)){
            case "available":
                int i = 0;
                int cnt = 0;
                long[] longs = new long[(int) input2];
                while (i < input2){
                    if (filter(input1, filter1) && filter(input1, filter2)){
                        longs[i] = input1;
                        i++;
                        cnt++;
                    }
                    input1++;
                }
                if (cnt > 0){
                    printProperties(longs);
                }
                break;
            case "negativeInput1":
                System.out.println("\nThe first parameter should be a natural number or zero.\n");
                break;
            case "wrongInput2":
                System.out.println("\nThe second parameter should be a natural number.\n");
                break;
            case "wrongProperty1":
            case "wrongProperty2":
                System.out.println("\nThe property [" + filter1 + "] is wrong.\n" +
                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]\n");
                break;
            case "mutuallyExclusiveProperties":
                System.out.println("\nThe request contains mutually exclusive properties: [ODD, EVEN]\n" +
                        "There are no numbers with these properties.\n");
                break;
            case "wrongProperties":
                System.out.println("\nThe properties [" + filter1 + ", " + filter2 + "] are wrong.\n" +
                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]\n");
                break;
            case "exit":
                System.out.println("\nGoodbye!");
                isContinue = false;
                break;
            default:
                break;
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
        System.out.println("\t\t" + "spy: " + isSpy(input));
        System.out.println("\t\t" + "square: " + isSquare(input));
        System.out.println("\t\t" + "sunny: " + isSunny(input));
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
                    + (isPalindromic(input1) ? "palindromic, " : "")
                    + (isGapful(input1) ? "gapful, " : "")
                    + (isSpy(input1) ? "spy, " : "")
                    + (isSquare(input1) ? "square, " : "")
                    + (isSunny(input1) ? "sunny, " : "")
            );
            input1++;
        }
    }
    static void printProperties(long[] longs){
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
            );
            longs[i]++;
        }
    }
}
