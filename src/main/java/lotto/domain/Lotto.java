package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 한 장의 로또 번호를 갖는 클래스
 */

public class Lotto {
    List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateScope(lottoNumbers);
        validateDuplication(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6자리여야 합니다.");
        }
    }

    private void validateScope(List<Integer> lottoNumbers) {
        lottoNumbers.forEach(this::validateNumber);
    }

    private void validateNumber(int number) {
        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException("범위(1 ~ 45)를 벗어난 수가 있습니다.");
        }
    }

    private void validateDuplication(List<Integer> lottoNumbers) {
        Set<Integer> duplication = new HashSet<>(lottoNumbers);
        if (lottoNumbers.size() != duplication.size()) {
            throw new IllegalArgumentException("한 세트 내에 중복된 번호가 있습니다.");
        }
    }
}
