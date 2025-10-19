package calculator.model;

import calculator.Utility;

public class Calculator {
    private String[] tokens;

    public Calculator(String[] tokens) {
        this.tokens = tokens;
    }

    public long calculate() {
        long result = 0;
        for(String token : tokens) {
            if(token.isBlank())
                continue;
            long num = Long.parseLong(token);
            result = Utility.safeAdd(result, num);
        }
        return result;
    }
}
