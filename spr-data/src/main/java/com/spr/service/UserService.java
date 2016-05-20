package com.spr.service;

import java.util.List;

import com.spr.exception.UserExists;
import com.spr.exception.UserNotFound;
import com.spr.model.Shop;
import com.spr.model.User;

public interface UserService {
	
	public User create(User user) throws UserExists;
	public User delete(int id) throws UserNotFound;
	public User delete(String eMail) throws UserNotFound;
	public List<User> findAll();
	public User update(User user) throws UserNotFound;
	public User findById(int id);
	public User findByEMail(String eMail);

}
