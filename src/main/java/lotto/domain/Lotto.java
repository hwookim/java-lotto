package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 한 장의 로또 번호를 갖는 클래스
 */

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.lottoNumbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6자리여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> lottoNumbers) {
        Set<Integer> duplication = new HashSet<>(lottoNumbers);
        if (lottoNumbers.size() != duplication.size()) {
            throw new IllegalArgumentException("한 세트 내에 중복된 번호가 있습니다.");
        }
    }
}
