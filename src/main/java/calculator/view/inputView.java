package calculator.view;

import calculator.Utility;
import camp.nextstep.edu.missionutils.Console;

public class inputView {
    public static void inputString() {
        String str = Console.readLine();
        String seperatorRegex = Utility.findCustomSeperator(str);
        str = Utility.makeTargetString(str);
    }
}
