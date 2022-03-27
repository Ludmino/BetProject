package l.godefroy.Api.service;
import l.godefroy.Api.model.Betlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import l.godefroy.Api.model.Bets;
import l.godefroy.Api.repository.BetsRepository;

import java.util.List;

@Service
public class BetsServiceImpl implements BetsService{

    @Autowired
    private BetsRepository betsRepository;

    @Override
    public List<Bets> find() {
        return betsRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Bets saveBet(Bets bets) {
        return betsRepository.save(bets);
    }

    @Override
    public void delete(Long id) {
        betsRepository.deleteById(id);
    }
}
