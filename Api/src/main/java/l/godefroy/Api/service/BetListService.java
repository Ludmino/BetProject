package l.godefroy.Api.service;

import l.godefroy.Api.model.Betlist;

import java.util.List;

public interface BetListService {
    List<Betlist> find();
    Betlist addBet(Betlist betlist);
    Betlist changeBetState(Long id, int etat);
    void delete(Long id);
}
