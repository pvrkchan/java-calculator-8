package calculator.model;

import java.util.regex.Pattern;

public class Parser {
    private static final String seperatorRegex = ",|:";

    public static String getRegex(String str) {
        if(hasOneCustomSeperator(str)) {
            return seperatorRegex + "|" + Pattern.quote(str.substring(2, 3));
        }
        return seperatorRegex;
    }

    public static String getParsableString(String str) {
        if(hasOneCustomSeperator(str)) {
            return str.substring(5); // "//;\n" 이후
        } else if(hasNoCustomSeperator(str)){
            return str.substring(4); // "//\n" 이후
        } else {
            return str; // 기본 문자열
        }
    }

    public static String[] parsing(String str, String regex) {
        return str.split(regex);
    }

    public static boolean hasOneCustomSeperator(String str) {
        return str.startsWith("//") && str.indexOf("\\n")==3;
    }

    public static boolean hasNoCustomSeperator(String str) {
        return str.startsWith("//") && str.indexOf("\\n")==2;
    }
}
