package numbers;

import java.util.Arrays;
import java.util.Locale;

import static numbers.Number.*;
import static numbers.Property.*;
import static numbers.Print.*;

public class Request {

    static boolean chooseRequest(String[] stringInputArray, int stringInputArrayLength) {
        boolean isContinue = true;
        long longNum = 0;
        long[] longInputArray = new long[2];

        //parse input with one parameter
        if (stringInputArrayLength < 2) {
            try {
                longNum = Long.parseLong(stringInputArray[0]);
            } catch (NumberFormatException e) {
                System.out.println("The first parameter should be a natural number or zero.");
                return isContinue;
            }
        }

        //parse input with two parameters
        else {
            for (int i = 0; i < 2; i++) {
                try {
                    longInputArray[i] = Long.parseLong(stringInputArray[i]);
                } catch (NumberFormatException e) {
                    if (i == 0) {
                        System.out.println("The first parameter should be a natural number or zero.");
                    }
                    if (i == 1) {
                        System.out.println("The second parameter should be a natural number.");
                        return isContinue;
                    }
                }
            }
        }

        if (stringInputArrayLength == 1) {
            isContinue = processRequest(longNum);
        } else if (stringInputArrayLength == 2) {
            isContinue = processRequest(longInputArray[0], longInputArray[1]);
        } else if (stringInputArrayLength > 2) {
            isContinue = processRequest(longInputArray[0], longInputArray[1],
                    Arrays.copyOfRange(stringInputArray, 2, stringInputArrayLength));
        } else if (stringInputArrayLength == 0) {
            printInstructions();
        }
        return isContinue;
    }

    static String checkRequest(long input) {
        String check = "";
        if (input > 0) {
            check = "available";
        } else if (input == 0) {
            check = "exit";
        } else {
            check = "notAvailable";
        }
        return check;
    }

    static String checkRequest(long input1, long input2) {
        String check = "";
        if (input1 > 0 && input2 > 0) {
            check = "available";
        } else if (input1 < 0) {
            check = "negativeInput1";
        } else if (input1 == 0) {
            check = "exit";
        } else if (input2 < 0 || input2 == 0) {
            check = "wrongInput2";
        }
        return check;
    }

    static boolean processRequest(long input) {
        boolean isContinue = true;
        switch (checkRequest(input)) {
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

    static boolean processRequest(long input1, long input2) {
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

    static boolean processRequest(long input1, long input2, String[] filters) {
        boolean isContinue = true;
        switch (checkRequest(input1, input2)) {
            case "available":
                filterRequest(input1, input2, filters);
                break;
            case "negativeInput1":
                System.out.println("\nThe first parameter should be a natural number or zero.\n");
                break;
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

    static void filterRequest(long input1, long input2, String[] filters) {
        String[] filteredProperties = checkProperty(filters);
        int cntWrong = 0;
        for (String filter : filteredProperties) {
            if (filter.startsWith("wrong")) {
                cntWrong++;
            }
        }
        if (cntWrong > 0) {
            String[] wrongs = new String[cntWrong];
            for (int i = 0; i < wrongs.length; i++) {
                for (int j = 0; j < filteredProperties.length; j++) {
                    if (filteredProperties[i].startsWith("wrong")) {
                        wrongs[i] = filteredProperties[i].replaceAll("wrong ", "").toUpperCase();
                        break;
                    }
                }
            }
            if (cntWrong == 1) {
                System.out.println("The property [" + wrongs[0] + "] is wrong.\n" +
                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]");
            } else {
                System.out.print("The properties [");
                for (int i = 0; i < wrongs.length; i++) {
                    if (i == wrongs.length - 1) {
                        System.out.print(wrongs[i]);
                    } else
                        System.out.print(wrongs[i] + ", ");
                }
                System.out.print("] are wrong.\n" +
                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]");
            }
        }
        else if (cntWrong == 0) {
            //check for mutually
            boolean isMutuallyExclusive = false;
            Property[] properties = new Property[filteredProperties.length];
            for (int i = 0; i < filters.length; i++) {
                properties[i] = Property.valueOf(filteredProperties[i].toUpperCase());
            }
            OuterFor:
            for (Property property : properties) {
                switch (property.ordinal()) {
                    case 0:
                        for (Property value : properties) {
                            if (value.ordinal() == 1) {
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + EVEN + ODD + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            }
                        }
                        break;
                    case 1:
                        for (Property value : properties) {
                            if (value.ordinal() == 0) {
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + EVEN + ODD + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            }
                        }
                        break;
                    case 2:
                        for (Property value : properties) {
                            if (value.ordinal() == 3) {
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + DUCK + SPY + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            }
                        }
                        break;
                    case 3:
                        for (Property value : properties) {
                            if (value.ordinal() == 2) {
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + DUCK + SPY + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            }
                        }
                        break;
                    case 4:
                        for (Property value : properties) {
                            if (value.ordinal() == 5) {
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + SQUARE + SUNNY + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            }
                        }
                        break;
                    case 5:
                        for (Property value : properties) {
                            if (value.ordinal() == 4) {
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + SQUARE + SUNNY + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            }
                        }
                        break;
                    default:
                        isMutuallyExclusive = false;
                        break;
                }
            }
            if (!isMutuallyExclusive) {
                int i = 0;
//                int cnt = 0;
                long[] longs = new long[(int) input2];
                while (i < input2) {
                    boolean b = true;
                    for (var p : properties) {
                        if (!filter(input1, p.getProperty())) {
                            b = false;
                            break;
                        }
                    }
                    if (b) {
                        longs[i] = input1;
                        i++;
                    }
                    input1++;
                }
                printProperties(longs);
            }
        }
    }
}