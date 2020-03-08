package lotto;

/**
 * 입력된 구입 금액을 갖는 클래스
 */
public class Money {
    private static final int LOTTO_PRICE = 1000;

    int money;

    public Money(int money) {
        validateLottoPrice(money);
        this.money = money;
    }

    private void validateLottoPrice(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("1000원 이상을 입력하세요.");
        }
    }
}
