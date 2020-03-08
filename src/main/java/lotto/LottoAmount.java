package lotto;

/**
 * 수동/자동 로또 장수를 저장하는 클래스
 */

public class LottoAmount {
    int manualAmount;
    int autoAmount;

    public LottoAmount(int totalAmount, int manualAmount) {
        validateManualAmount(totalAmount, manualAmount);
        this.manualAmount = manualAmount;
        this.autoAmount = totalAmount - manualAmount;
    }

    private void validateManualAmount(int totalAmount, int manualAmount) {
        if (manualAmount < 0) {
            throw new IllegalArgumentException("양수를 입력하세요.");
        }
        if (totalAmount < manualAmount) {
            throw new IllegalArgumentException("전체 로또보다 많을 수 없습니다.");
        }
    }
}
