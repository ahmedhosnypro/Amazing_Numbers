package numbers;

class Number{
    long value;
    Number (long number){
        this.value = number;
    }


    boolean isEven (){
        return value % 2 == 0;
    }
    boolean isOdd (){
        return value % 2 != 0;
    }
    boolean isBuzz () {
        if (value > 10) {
            long lastDigit = value % 10;
            return value % 7 == 0 || lastDigit == 7;
        }
        else return value == 7;
    }
    boolean isDuck(){
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
    boolean isPalindromic (){
        String toString = String.valueOf(value);
        StringBuilder sb2 = new StringBuilder(String.valueOf(value)).reverse();
        String reversedString  = sb2.toString();
        return toString.equals(reversedString);
    }
    boolean isGapful(){
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
    boolean isSpy (){
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
}
