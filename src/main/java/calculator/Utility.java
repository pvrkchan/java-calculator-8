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

    public static long safeAdd(long a, long b) {
        if (a > (Long.MAX_VALUE - b))
            throw new IllegalArgumentException("저장할 수 있는 수의 범위를 초과했습니다. 다시 입력해주세요.");
        return a + b;
    }
}
