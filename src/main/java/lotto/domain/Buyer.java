package lotto.domain;

import lotto.domain.lottoTicket.Lotto;
import lotto.domain.lottoTicket.LottoFactory;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private List<Lotto> lottos = new ArrayList<>();

    public Buyer(int lottoTicketCount) {
        createLottos(lottoTicketCount);
    }

    private void createLottos(int lottoTicketCount) {
        new LottoFactory();
        for (int i = 0; i < lottoTicketCount; i++) {
            this.lottos.add(new Lotto(LottoFactory.createLottoNumbers()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
