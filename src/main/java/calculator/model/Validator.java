package calculator.model;

public class Validator {
    public static void validateCustomSeperator(String str){
        if(str.startsWith("//")){
            int index = str.indexOf("\\n");
            if(index!=2 && index!=3)
                throw new IllegalArgumentException("커스텀 문자의 입력이 잘못되었습니다.");
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
