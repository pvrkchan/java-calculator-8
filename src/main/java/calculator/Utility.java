package calculator;

import java.util.regex.Pattern;

public class Utility {
    public static String findCustomSeperator(String str) {
        String seperatorRegex = ",|:";
        if(str.startsWith("//") && str.indexOf("\\n")==3) {
            seperatorRegex += "|" + Pattern.quote(str.substring(2, 3));
        }
        return seperatorRegex;
    }

    public static String makeTargetString(String str) {
        if(str.startsWith("//") && str.indexOf("\\n")==3){
            return str.substring(5);
        } else if(str.startsWith("//") && str.indexOf("\\n")==2){
            return str.substring(4);
        } else {
            return str;
        }
    }
}
