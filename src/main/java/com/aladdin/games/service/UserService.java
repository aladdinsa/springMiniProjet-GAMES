package com.aladdin.games.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aladdin.games.entities.User;

public interface UserService {
	List<User> getAllUsers();

	User saveUser(User user);

	Page<User> getAllUsersParPage(int page, int size);

	void deleteUserById(Long id);

	User getUser(Long id);

	User updateUser(User u);

}
