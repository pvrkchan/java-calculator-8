package calculator;

public class Validator {
    public static long safeAdd(long a, long b) {
        if (a > (Long.MAX_VALUE - b))
            throw new IllegalArgumentException("저장할 수 있는 수의 범위를 초과했습니다. 다시 입력해주세요.");
        return a + b;
    }
}
