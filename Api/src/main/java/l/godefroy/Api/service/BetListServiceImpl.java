package l.godefroy.Api.service;

import java.util.List;

import l.godefroy.Api.model.Betlist;
import l.godefroy.Api.repository.BetListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetListServiceImpl implements BetListService{

    @Autowired
    private BetListRepository betlistRepository;

    @Override
    public List<Betlist> find() {
        return betlistRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Betlist addBet(Betlist betlist) {
        return betlistRepository.save(betlist);
    }

    @Override
    public Betlist changeBetState(Long id, int etat) {
        return betlistRepository.findById(id).map(betlist -> {
                betlist.setEtat(etat);
                    return betlistRepository.save(betlist);
                }
        ).orElse(null);
    }

    @Override
    public void delete(Long id) {
        betlistRepository.deleteById(id);
    }
}
