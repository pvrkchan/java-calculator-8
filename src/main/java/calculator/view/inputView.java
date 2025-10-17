package calculator.view;

import calculator.Utility;
import camp.nextstep.edu.missionutils.Console;

public class inputView {
    public static void inputString() {
        String str = Console.readLine();
        validateCustomSeperator(str);
        String seperatorRegex = Utility.findCustomSeperator(str);
        str = Utility.makeTargetString(str);
    }

    public static void validateCustomSeperator(String str){
        if(str.startsWith("//")){
            int index = str.indexOf("\\n");
            if(index!=3)
                throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }
    }
}
