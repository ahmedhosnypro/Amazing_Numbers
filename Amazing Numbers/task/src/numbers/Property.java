package numbers;

import java.util.Arrays;

public enum Property {
    EVEN("EVEN"),
    NOTEVEN("NOTEVEN"),
    ODD("ODD"),
    NOTODD("NOTODD"),
    DUCK("DUCK"),
    NOTDUCK("NOTDUCK"),
    SPY("SPY"),
    NOTSPY("NOTSPY"),
    SQUARE("SQUARE"),
    NOTSQUARE("NOTSQUARE"),
    SUNNY("SUNNY"),
    NOTSUNNY("NOTSUNNY"),
    BUZZ("BUZZ"),
    NOTBUZZ("NOTBUZZ"),
    PALINDROMIC("PALINDROMIC"),
    NOTPALINDROMIC("NOTPALINDROMIC"),
    GAPFUL("GAPFUL"),
    NOTGAPFUL("NOTGAPFUL"),
    JUMPING("JUMPING"),
    NOTJUMPING("NOTJUMPING"),
    HAPPY("HAPPY"),
    NOTHAPPY("NOTHAPPY"),
    SAD("SAD"),
    NOTSAD("NOTSAD");

    private final String property;
    Property(String property){
        this.property = property;
    }

    String getProperty(){
        return this.property;
    }

    static String[] checkProperty(String[] filters){
        String[] result = new String[filters.length];
        for (int i = 0; i < filters.length; i++){
            if (filters[i].startsWith("-")){
                String removedMinus = filters[i].substring(1);
                try {
                    Property property = Property.valueOf(("NOT" + removedMinus).toUpperCase());
                    result[i] = property.getProperty();
                }
                catch (IllegalArgumentException e) {
                    result[i] = "wrong " + removedMinus;
                }
            }
            else {
                try {
                    Property property = Property.valueOf(filters[i].toUpperCase());
                    result[i] = property.getProperty();
                } catch (IllegalArgumentException e) {
                    result[i] = "wrong " + filters[i];
                }
            }
        }
        return result;
    }

    static boolean isMutuallyExclusive(Property[] properties) {
        boolean isMutuallyExclusive = false;

        OuterFor:
        for (Property property : properties) {
            switch (property) {
                case EVEN:
                    for (Property value : properties) {
                        switch (value) {
                            case ODD:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + EVEN + ", " + ODD + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            case NOTEVEN:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + EVEN + ", " + "-EVEN" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            default:
                                break;
                        }
                    }
                    break;
                case NOTEVEN:
                    for (Property value : properties) {
                        switch (value) {
                            case NOTODD:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + "-EVEN" + ", " + "-ODD" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            case EVEN:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + EVEN + ", " + "-EVEN" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            default:
                                break;
                        }
                    }
                    break;
                case ODD:
                    for (Property value : properties) {
                        switch (value) {
                            case EVEN:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + EVEN + ", " + ODD + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            case NOTODD:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + ODD + ", " + "-ODD" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            default:
                                break;
                        }
                    }
                    break;
                case NOTODD:
                    for (Property value : properties) {
                        switch (value) {
                            case NOTEVEN:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + "-EVEN" + ", " + "-ODD" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            case ODD:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + ODD + ", " + "-ODD" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            default:
                                break;
                        }
                    }
                    break;
                case DUCK:
                    for (Property value : properties) {
                        switch (value) {
                            case SPY:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + DUCK + ", " + SPY + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            case NOTDUCK:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + DUCK + ", " + "-DUCK" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            default:
                                break;
                        }
                    }
                    break;
                case NOTDUCK:
                    for (Property value : properties) {
                        switch (value) {
                            case DUCK:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + DUCK + ", " + "-DUCK" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            case NOTSPY:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + "-DUCK" + ", " + "-SPY" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            default:
                                break;
                        }
                    }
                    break;
                case SPY:
                    for (Property value : properties) {
                        switch (value) {
                            case DUCK:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + DUCK + ", " + SPY + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            case NOTSPY:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + SPY + ", " + "-SPY" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            default:
                                break;
                        }
                    }
                    break;
                case NOTSPY:
                    for (Property value : properties) {
                        switch (value) {
                            case NOTDUCK:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + "-DUCK" + ", " + "-SPY" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            case SPY:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + SPY + ", " + "-SPY" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            default:
                                break;
                        }
                    }
                    break;
                case SQUARE:
                    for (Property value : properties) {
                        switch (value) {
                            case SUNNY:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + SQUARE + ", " + SUNNY + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            case NOTSQUARE:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + SQUARE + ", " + "-SQUARE" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            default:
                                break;
                        }
                    }
                    break;
                case NOTSQUARE:
                    for (Property value : properties) {
                        switch (value) {
                            case SQUARE:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + SQUARE + ", " + "-SQUARE" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            default:
                                break;
                        }
                    }
                    break;
                case SUNNY:
                    for (Property value : properties) {
                        switch (value) {
                            case SQUARE:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + SQUARE + ", " + SUNNY + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            case NOTSUNNY:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + SUNNY + ", " + "-SUNNY" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            default:
                                break;
                        }
                    }
                    break;
                case NOTSUNNY:
                    for (Property value : properties) {
                        switch (value) {
                            case SUNNY:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + SUNNY + ", " + "-SUNNY" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            default:
                                break;
                        }
                    }
                    break;
                case BUZZ:
                    for (Property value : properties) {
                        switch (value) {
                            case NOTBUZZ:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + BUZZ + ", " + "-BUZZ" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            default:
                                break;
                        }
                    }
                    break;
                case NOTBUZZ:
                    for (Property value : properties) {
                        switch (value) {
                            case BUZZ:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + BUZZ + ", " + "-BUZZ" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            default:
                                break;
                        }
                    }
                    break;
                case GAPFUL:
                    for (Property value : properties) {
                        switch (value) {
                            case NOTGAPFUL:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + GAPFUL + ", " + "-GAPFUL" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            default:
                                break;
                        }
                    }
                    break;
                case NOTGAPFUL:
                    for (Property value : properties) {
                        switch (value) {
                            case GAPFUL:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + GAPFUL + ", " + ", " + "-GAPFUL" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            default:
                                break;
                        }
                    }
                    break;
                case JUMPING:
                    for (Property value : properties) {
                        switch (value) {
                            case NOTJUMPING:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + JUMPING + ", " + "-JUMPING" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            default:
                                break;
                        }
                    }
                    break;
                case NOTJUMPING:
                    for (Property value : properties) {
                        switch (value) {
                            case JUMPING:
                                System.out.println("The request contains mutually exclusive properties: ["
                                        + JUMPING + ", " + "-JUMPING" + "]\n" +
                                        "There are no numbers with these properties.");
                                isMutuallyExclusive = true;
                                break OuterFor;
                            default:
                                break;
                        }
                    }
                    break;
                default:
                    isMutuallyExclusive = false;
                    break;
            }
        }
        return isMutuallyExclusive;
    }
}
