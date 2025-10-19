package calculator;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {
    public void run() {
        Calculator calculator = new Calculator();
        OutputView.printResult(calculator.calculate(InputView.inputString()));
    }
}
