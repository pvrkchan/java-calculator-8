package calculator;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {
    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Calculator calculator = new Calculator(InputView.inputString());
        OutputView.printResult(calculator.calculate());
    }
}
