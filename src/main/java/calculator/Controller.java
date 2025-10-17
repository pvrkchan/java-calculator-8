package calculator;

import calculator.model.Calculator;
import calculator.view.InputView;

public class Controller {
    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Calculator calculator = new Calculator(InputView.inputString());
        calculator.calculate();
    }
}
