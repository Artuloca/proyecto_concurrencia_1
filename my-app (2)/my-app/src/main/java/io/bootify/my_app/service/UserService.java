package io.bootify.my_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.bootify.my_app.repos.UserRepository;
import io.bootify.my_app.domain.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
