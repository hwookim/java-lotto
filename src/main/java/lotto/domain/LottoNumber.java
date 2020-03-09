package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 각 로또 숫자를 갖는 클래스
 */

public class LottoNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final Map<Integer, LottoNumber> numbers = new HashMap<>();

    static {
        IntStream.rangeClosed(MIN, MAX)
                .forEach(i -> numbers.put(i, new LottoNumber(i)));
    }

    private int lottoNumber;

    private LottoNumber(int number) {
        this.lottoNumber = number;
    }

    public static LottoNumber of(int number) {
        validateScope(number);
        return numbers.get(number);
    }

    private static void validateScope(int number) {
        if (!numbers.containsKey(number)) {
            throw new IllegalArgumentException("범위(1 ~ 45)를 벗어난 숫자가 있습니다.");
        }
    }
}
