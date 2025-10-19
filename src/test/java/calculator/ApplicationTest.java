package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 빈_문자열입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용X() {
        assertSimpleTest(() -> {
            run("//\\n1:2,4");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void 일반_구분자_사용_여러숫자() {
        assertSimpleTest(() -> {
            run("123,5,6:7");
            assertThat(output()).contains("결과 : 141");
        });
    }

    @Test
    void 최대값_계산(){
        assertSimpleTest(() -> {
            run("9223372036854775806,1");
            assertThat(output()).contains("결과 : 9223372036854775807");
        });
    }

    @Test
    void 예외_커스텀_구분자_2글자() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//*^\\n1,23"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_음수() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_제로() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_등록되지_않은_구분자(){
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//*\\n1,2.3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_오버플로우(){
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
