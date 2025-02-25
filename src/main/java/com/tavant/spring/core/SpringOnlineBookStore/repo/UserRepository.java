package com.tavant.spring.core.SpringOnlineBookStore.repo;

import java.util.List;

import com.tavant.spring.core.SpringOnlineBookStore.entity.User;

public interface UserRepository {

	void addUser(User user);
	void updateUser(User user);
	User getUserById(int id);
	List<User> getAllUsers();
	void deleteUser(int id);
}
