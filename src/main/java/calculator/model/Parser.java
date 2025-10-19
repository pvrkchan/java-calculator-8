package calculator.model;

import java.util.regex.Pattern;

public class Parser {
    private static String seperatorRegex = ",|:";

    public static String extractCustomSeperator(String str) {
        if(hasOneCustomSeperator(str)) {
            seperatorRegex += "|" + Pattern.quote(str.substring(2, 3));
            return str.substring(5);
        } else if(hasNoCustomSeperator(str)){
            return str.substring(4);
        } else {
            return str;
        }
    }

    public static String[] parsing(String str) {
        return str.split(seperatorRegex);
    }

    public static boolean hasOneCustomSeperator(String str) {
        return str.startsWith("//") && str.indexOf("\\n")==3;
    }

    public static boolean hasNoCustomSeperator(String str) {
        return str.startsWith("//") && str.indexOf("\\n")==2;
    }
}
