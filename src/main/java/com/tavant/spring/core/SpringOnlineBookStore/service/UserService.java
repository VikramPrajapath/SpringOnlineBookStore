package com.tavant.spring.core.SpringOnlineBookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.spring.core.SpringOnlineBookStore.entity.User;
import com.tavant.spring.core.SpringOnlineBookStore.repo.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;

	@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }

    public User authenticate(String email, String password) {
        return userRepository.getAllUsers().stream()
                .filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
                .findFirst().orElse(null);
    }
}
