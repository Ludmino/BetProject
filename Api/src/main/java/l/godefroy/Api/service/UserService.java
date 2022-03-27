package l.godefroy.Api.service;

import l.godefroy.Api.model.User;

import java.util.List;

public interface UserService {
    List<User> find();
    List<User> findUsername(String username);

    User saveUser(User user);
    User updateUser(Long id, int points);
    void delete(Long id);
}
