package com.aladdin.games.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aladdin.games.entities.User;
import com.aladdin.games.repos.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Page<User> getAllUsersParPage(int page, int size) {
		return userRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);

	}

	@Override
	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User updateUser(User u) {
		return userRepository.save(u);
	}

}
