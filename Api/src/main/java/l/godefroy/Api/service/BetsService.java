package l.godefroy.Api.service;
import l.godefroy.Api.model.Bets;

import java.util.List;

public interface BetsService {
    List<Bets> find();
    Bets saveBet(Bets bets);
    void delete(Long id);
}
