package numbers;

public class Number{
    public static boolean isEven (long value){
        return value % 2 == 0;
    }
    static boolean isOdd (long value){
        return value % 2 != 0;
    }
    static boolean isBuzz (long value) {
        if (value > 10) {
            long lastDigit = value % 10;
            return value % 7 == 0 || lastDigit == 7;
        }
        else return value == 7;
    }
    static boolean isDuck(long value){
        String toString = String.valueOf(value);
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
    static boolean isPalindromic (long value){
        String toString = String.valueOf(value);
        StringBuilder sb2 = new StringBuilder(String.valueOf(value)).reverse();
        String reversedString  = sb2.toString();
        return toString.equals(reversedString);
    }
    static boolean isGapful(long value){
        String s = String.valueOf(value);
        boolean isGapful = false;
        if (s.length() >= 3){
            char fstDigit = s.charAt(0);
            char lstDigit = s.charAt(s.length() - 1);
            String concatenated = fstDigit + "" + lstDigit;
            long concatNumber = Long.parseLong(concatenated);
            if (value % concatNumber == 0)
                isGapful = true;
        }
        return isGapful;
    }
    static boolean isSpy (long value){
        String s = String.valueOf(value);
        long sum = 0;
        long product =1;
        for (int i = 0; i < s.length(); i++) {
            int n = Integer.parseInt(String.valueOf(s.charAt(i)));
            sum += n;
            product *= n;
        }
        return sum == product;
    }
    static boolean isSquare(long value){
        long sqrt = (long) Math.sqrt(value);
        return sqrt * sqrt == value;
    }
    static boolean isSunny(long value){
        return isSquare(value + 1L);
    }
    static boolean isJumping (long value){
        boolean isJumping = false;
        if (value < 10){
            isJumping = true;
        }
        else {
            int n1 = 0;
            int n2 = 0;
            do {
                n1 = (int) value % 10;
                value /= 10;
                n2 = (int) value % 10;
                if ((n1 - n2 == 1) || (n2 - n1 == 1)) {
                    isJumping = true;
                }
                else {
                    isJumping = false;
                    break;
                }
            }
            while (value > 9);
        }
        return isJumping;
    }
    static boolean filter(long num, String filter){
        filter = filter.toUpperCase();
        Property property = Property.valueOf(filter);
        boolean isFiltered = false;
        switch (property) {
            case EVEN:
                if (isEven(num)) {
                    isFiltered = true;
                }
                break;
            case ODD:
                if (isOdd(num)) {
                    isFiltered = true;
                }
                break;
            case BUZZ:
                if (isBuzz(num)) {
                    isFiltered = true;
                }
                break;
            case DUCK:
                if (isDuck(num)) {
                    isFiltered = true;
                }
                break;
            case PALINDROMIC:
                if (isPalindromic(num)) {
                    isFiltered = true;
                }
                break;
            case GAPFUL:
                if (isGapful(num)) {
                    isFiltered = true;
                }
                break;
            case SPY:
                if (isSpy(num)) {
                    isFiltered = true;
                }
                break;
            case SQUARE:
                if (isSquare(num)) {
                    isFiltered = true;
                }
                break;
            case SUNNY:
                if (isSunny(num)) {
                    isFiltered = true;
                }
                break;
            case JUMPING:
                if (isJumping(num)){
                    isFiltered = true;
                }
                break;
            default:
                break;
        }
        return isFiltered;
    }
}
