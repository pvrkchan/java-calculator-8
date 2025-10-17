package calculator.view;

import calculator.Utility;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String[] inputString() {
        String str = Console.readLine();
        validateCustomSeperator(str);
        String seperatorRegex = Utility.findCustomSeperator(str);
        str = Utility.makeTargetString(str);
        String[] tokens = str.split(seperatorRegex);
        validateNumber(tokens);
        return tokens;
    }

    public static void validateCustomSeperator(String str){
        if(str.startsWith("//")){
            int index = str.indexOf("\\n");
            if(index!=3)
                throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }
    }

    public static void validateNumber(String[] tokens){
        for(String token : tokens){
            if(token.isBlank())
                continue;
            try{
                long num = Long.parseLong(token);
                if(num <= 0)
                    throw new IllegalArgumentException("양수만을 입력하세요.");
            } catch(NumberFormatException e){
                throw new IllegalArgumentException("구분자 이외의 문자가 발견되었습니다.");
            }
        }
    }
}
