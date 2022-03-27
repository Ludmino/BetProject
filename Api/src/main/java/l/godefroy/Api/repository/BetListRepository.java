package l.godefroy.Api.repository;

import l.godefroy.Api.model.Betlist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetListRepository extends CrudRepository<Betlist,Long>{
    List<Betlist> findAllByOrderByIdAsc();
}