package calculator.model;

public class Calculator {

    public long calculate(String input) {
        Validator.validateCustomSeperator(input);
        String regex = Parser.getRegex(input);
        String parsableString = Parser.getParsableString(input);
        String[] tokens = Parser.parsing(parsableString, regex);
        Validator.validateNumber(tokens);

        long result = 0;
        for(String token : tokens) {
            if(token.isBlank())
                continue;
            long num = Long.parseLong(token);
            result = safeAdd(result, num);
        }
        return result;
    }

    public static long safeAdd(long a, long b) {
        if (a > (Long.MAX_VALUE - b))
            throw new IllegalArgumentException("저장할 수 있는 수의 범위를 초과했습니다. 다시 입력해주세요.");
        return a + b;
    }
}
