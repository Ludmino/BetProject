package l.godefroy.Api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import l.godefroy.Api.model.User;
import l.godefroy.Api.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> find() {
        return userRepository.findAllByOrderByIdAsc();
    }

    @Override
    public List<User> findUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, int quantity) {
        return userRepository.findById(id).map(user -> {
            user.setPoints(quantity);
            return userRepository.save(user);
        }
        ).orElse(null);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
