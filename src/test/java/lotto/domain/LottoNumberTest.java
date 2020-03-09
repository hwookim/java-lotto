package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @ParameterizedTest
    @DisplayName("LottoNumber 생성 테스트")
    @ValueSource(ints = {1, 45})
    void initTest(int input) {
        assertThatCode(() -> LottoNumber.of(input))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("LottoNumber 생성 실패 테스트")
    @ValueSource(ints = {-1, 46})
    void initFailTest(int input) {
        assertThatThrownBy(() -> LottoNumber.of(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
