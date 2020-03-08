package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    static Stream<Arguments> lottoInput() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 46)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, -1)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 5))
        );
    }

    @Test
    @DisplayName("Lotto 생성 테스트")
    void initTest() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatCode(() -> new Lotto(lottoNumbers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("Lotto 생성 실패 테스트")
    @MethodSource("lottoInput")
    void innitFailTest(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
