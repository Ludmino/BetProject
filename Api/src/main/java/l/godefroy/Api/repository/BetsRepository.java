package l.godefroy.Api.repository;

import l.godefroy.Api.model.Bets;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetsRepository extends CrudRepository<Bets,Long>{
    List<Bets> findAllByOrderByIdAsc();
}