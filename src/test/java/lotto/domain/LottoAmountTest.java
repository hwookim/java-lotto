package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAmountTest {
    @Test
    @DisplayName("LottoAmount 생성 테스트")
    void initTest() {
        assertThatCode(() -> new LottoAmount(10, 10))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("LottoAmount 생성 실패 테스트")
    @ValueSource(ints = {-1, 100})
    void initFailTest(int manualAmount) {
        assertThatThrownBy(() -> new LottoAmount(1, manualAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
