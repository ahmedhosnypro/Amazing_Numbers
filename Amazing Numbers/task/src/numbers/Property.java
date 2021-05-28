package numbers;

import java.util.Arrays;

public enum Property {
    EVEN("EVEN"),
    ODD("ODD"),
    DUCK("DUCK"),
    SPY("SPY"),
    SQUARE("SQUARE"),
    SUNNY("SUNNY"),
    BUZZ("BUZZ"),
    PALINDROMIC("PALINDROMIC"),
    GAPFUL("GAPFUL"),
    JUMPING("JUMPING");

    private final String property;
    Property(String property){
        this.property = property;
    }

    public String getProperty(){
        return this.property;
    }


    public static String[] checkProperty(String[] filters){
        String[] result = new String[filters.length];
        for (int i = 0; i < filters.length; i++){
            try {
                Property property = Property.valueOf(filters[i].toUpperCase());
                result[i] = property.getProperty();
            }
            catch (IllegalArgumentException e) {
                result[i] = "wrong " + filters[i];
            }
        }
        return result;
    }
    /*
    public static boolean checkProperty (String filter1, String filter2){
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

     */
}
