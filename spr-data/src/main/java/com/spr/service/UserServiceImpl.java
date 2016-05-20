package com.spr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.spr.exception.UserExists;
import com.spr.exception.UserNotFound;
import com.spr.model.Shop;
import com.spr.model.User;
import com.spr.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;

	@Override
	public User create(User user) throws UserExists {
		User createdUser = userRepository.findbyEMail(user.geteMail());

		if (createdUser != null) {
			throw new UserExists();
		}
		createdUser = user;
		return userRepository.save(createdUser);
	}

	@Override
	public User delete(int id) throws UserNotFound {
		User user = userRepository.findOne(id);
		if (user == null) {
			throw new UserNotFound();
		}
		userRepository.delete(id);
		return user;
	}

	@Override
	public User delete(String eMail) throws UserNotFound {
		User user = userRepository.findbyEMail(eMail);
		if (user == null) {
			throw new UserNotFound();
		}
		userRepository.deleteUserByEMail(eMail);
		return user;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User update(User user) throws UserNotFound {
		User userSaved = userRepository.save(user);
		return userSaved;
	}

	@Override
	public User findById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public User findByEMail(String eMail) {
		return userRepository.findbyEMail(eMail);
	}
}
