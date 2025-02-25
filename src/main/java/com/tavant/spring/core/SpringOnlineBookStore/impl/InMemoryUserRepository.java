package com.tavant.spring.core.SpringOnlineBookStore.impl;

import java.util.ArrayList;
import java.util.List;
import com.tavant.spring.core.SpringOnlineBookStore.entity.User;
import com.tavant.spring.core.SpringOnlineBookStore.repo.UserRepository;

public class InMemoryUserRepository implements UserRepository {
    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void deleteUser(int userId) {
        users.removeIf(user -> user.getId() == userId);
    }

    @Override
public void updateUser(User user) {
    for (int i = 0; i < users.size(); i++) {
        if (users.get(i).getId() == user.getId()) {
            users.set(i, user);
            return;
        }
    }
    users.add(user);
}

    @Override
    public User getUserById(int id) {
        return users.stream()
                    .filter(user -> user.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

	
}
