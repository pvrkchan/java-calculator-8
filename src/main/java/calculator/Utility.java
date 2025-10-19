package calculator;

import java.util.regex.Pattern;

public class Utility {
    public static String findCustomSeperator(String str) {
        String seperatorRegex = ",|:";
        if(hasOneCustomSeperator(str)) {
            seperatorRegex += "|" + Pattern.quote(str.substring(2, 3));
        }
        return seperatorRegex;
    }

    public static String makeTargetString(String str) {
        if(hasOneCustomSeperator(str)){
            return str.substring(5);
        } else if(hasNoCustomSeperator(str)){
            return str.substring(4);
        } else {
            return str;
        }
    }

    public static boolean hasOneCustomSeperator(String str) {
        return str.startsWith("//") && str.indexOf("\\n")==3;
    }

    public static boolean hasNoCustomSeperator(String str) {
        return str.startsWith("//") && str.indexOf("\\n")==2;
    }
}
