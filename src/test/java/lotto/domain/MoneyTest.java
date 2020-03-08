package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @Test
    @DisplayName("Money 생성 성공 테스트")
    void initTest() {
        assertThatCode(() -> new Money(1000))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("Money 생성 실패 테스트")
    @ValueSource(ints = {999, -1})
    void initFailTest(int input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
