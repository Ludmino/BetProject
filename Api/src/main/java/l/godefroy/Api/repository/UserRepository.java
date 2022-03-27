package l.godefroy.Api.repository;

import l.godefroy.Api.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
    List<User> findAllByOrderByIdAsc();
    List<User> findByUsername(String username);
}