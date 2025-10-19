package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 계산기_빈_문자열_입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 계산기_커스텀_구분자_포함_문자열_입력() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 계산기_커스텀_구분자_포함X_문자열_입력() {
        assertSimpleTest(() -> {
            run("//\\n1:2,4");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void 계산기_디폴트_구분자_사용_여러_숫자_입력() {
        assertSimpleTest(() -> {
            run("123,5,6:7");
            assertThat(output()).contains("결과 : 141");
        });
    }

    @Test
    void 계산기_구분자_사이에_없는_경우() {
        assertSimpleTest(() -> {
            run(",,1,,2,3:4::");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 계산기_최대값_도출_입력(){
        assertSimpleTest(() -> {
            run("9223372036854775806,1");
            assertThat(output()).contains("결과 : 9223372036854775807");
        });
    }

    @Test
    void 계산기_커스텀_구분자_2글자_예외처리() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//*^\\n1,23"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 계산기_음수_포함_예외처리() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 계산기_제로_포함_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 계산기_등록되지_않은_구분자_예외처리(){
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//*\\n1,2.3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 계산기_계산결과_오버플로우_예외처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("9223372036854775807,1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
