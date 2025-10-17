package calculator;

import java.util.regex.Pattern;

public class Utility {
    public static String findCustomSeperator(String str) {
        String seperatorRegex = ",|:";
        if(str.startsWith("//")){
            int index = str.indexOf("\\n");
            if(index!=3)
                throw new IllegalArgumentException("입력이 잘못되었습니다.");
            seperatorRegex += "|" + Pattern.quote(str.substring(2,3));
        }
        return seperatorRegex;
    }

    public static String makeTargetString(String str) {
        if(str.startsWith("//")){
            return str.substring(5);
        } else {
            return str;
        }
    }
}
